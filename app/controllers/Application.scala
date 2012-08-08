package controllers

import play.api.mvc._
import ua.net.resources.service.Submodules
import ua.net.resources.model.{CoreSubmodules, NavItem}
import ua.net.resources.domain.{Region, Pages}
import ua.net.resources.controllers.{Navigation, LocaleChange}
import ua.net.resources.mappings.MyForms._
import play.api.data._
import play.api.data.Forms._
import scala.Long
import ua.net.resources.Constants

object Application extends Controller with LocaleChange with Navigation {

  val mainPageFormBinder = Form(
    mapping(
      Constants.id_pages -> optionalLongNumber,
      Constants.id_regions -> optionalLongNumber
    )(MainPageForm.apply)(MainPageForm.unapply)
  )

  def mainPage() = Action { implicit request =>
    val form = mainPageFormBinder.bindFromRequest().get

    val page = Pages.findByIdOrElseMainPage(form.id_pages)

    val region = form.id_region.flatMap(Region.findById(_))

    implicit val coreSubmodules = Submodules.coreSubmodules(page, region)

    Ok(views.html.main.pages())
  }

}

case class MainPageForm(id_pages: Option[Long], id_region: Option[Long])