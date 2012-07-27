package ua.net.resources.controllers

import play.api.mvc.{Cookie, RequestHeader, Action, Controller}
import play.api.data.Form
import play.api.data._
import play.api.data.Forms._
import play.api.Logger
import play.api.i18n.Lang

/**
 * User: slayer
 * Date: 27.07.12
 */
trait LocaleChange extends Controller {

  def changeLang(lang: Option[String]) = Action { implicit request =>
    val referrer = request.headers.get(REFERER).getOrElse("/")
    if (lang.isDefined) {
      Logger.logger.debug("Change locale to : " + lang.get)
      Redirect(referrer).withCookies(Cookie(LANG, lang.get))
    } else {
      Logger.logger.debug("The locale can not be changed to nothing")
      BadRequest(referrer)
    }
  }

  override implicit def lang(implicit request: RequestHeader) = {
    request.cookies.get(LANG) match {
      case None => super.lang(request)
      case Some(cookie) => Lang(cookie.value)
    }
  }

  private val LANG = "lang"
}
