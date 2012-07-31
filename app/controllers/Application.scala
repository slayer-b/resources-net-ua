package controllers

import play.api.mvc._
import ua.net.resources.service.Submodules
import ua.net.resources.model.NavItem
import ua.net.resources.domain.{Region, Pages}
import ua.net.resources.controllers.LocaleChange
import ua.net.resources.mappings.MyForms._
import play.api.data._
import play.api.data.Forms._
import scala.Long

object Application extends Controller with LocaleChange {

  implicit val navigation: Seq[NavItem] = Array(NavItem("item-1"), NavItem("item-2"))

  val myFormBinder = Form(
    mapping(
      "id_pages" -> optionalLongNumber,
      "id_regions" -> optionalLongNumber
    )(MyForm.apply)(MyForm.unapply)
  )
  
  def mainPage() = Action { implicit request =>
    val myForm = myFormBinder.bindFromRequest().get

    val page = myForm.id_pages match {
      case Some(id) => Pages.findPage(id)
      case None => Pages.findMainPage()
    }

    val region = myForm.id_region.flatMap(Region.findById(_))

    implicit val coreSubmodules = Submodules.coreSubmodules(page, region)

    Ok(views.html.main.pages())
  }

}

case class MyForm(id_pages: Option[Long], id_region: Option[Long])