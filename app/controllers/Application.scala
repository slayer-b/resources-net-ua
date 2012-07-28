package controllers

import play.api._
import i18n.Lang
import play.api.mvc._
import ua.net.resources.service.{Submodules}
import ua.net.resources.model.NavItem
import ua.net.resources.domain.{Pages, Counter}
import ua.net.resources.controllers.LocaleChange

object Application extends Controller with Submodules with LocaleChange {

  implicit val navigation: Seq[NavItem] = Array(NavItem("item-1"), NavItem("item-2"))
  
  def mainPage() = Action { implicit request =>
    implicit val page = Pages.findMainPage()
    Ok(views.html.main.pages())
  }

  def otherPage(id_pages: Option[Long]) = Action { implicit request =>
    implicit val page = id_pages match {
      case Some(id) => Pages.findPage(id)
      case None => Pages.findMainPage()
    }
    Ok(views.html.main.pages())
  }
}
