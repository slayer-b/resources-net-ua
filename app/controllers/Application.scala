package controllers

import play.api.mvc._
import ua.net.resources.service.Submodules
import ua.net.resources.model.NavItem
import ua.net.resources.domain.{Region, Pages}
import ua.net.resources.controllers.LocaleChange
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import scala.Long

object Application extends Controller with LocaleChange {

  implicit val navigation: Seq[NavItem] = Array(NavItem("item-1"), NavItem("item-2"))

  val myFormBinder: Form[(Long, Long)] = Form(
    tuple(
      "id_pages" -> longNumber,
      "id_regions" -> longNumber
    )
  )
  
  def mainPage() = Action { implicit request =>
    val myForm = myFormBinder.bindFromRequest.fold(
      errors => MyForm(None, None),
      (success: (Long, Long)) => MyForm(Some(success._1), Some(success._2))
    )

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