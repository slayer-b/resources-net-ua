package ua.net.resources.controllers

import ua.net.resources.model.{NavItem, CoreSubmodules}
import ua.net.resources.domain.{Region, PagesNav, Pages}
import play.api.Logger
import controllers.routes._
import ua.net.resources.{model, Constants}
import annotation.tailrec

/**
 * User: slayer
 * Date: 06.08.12
 */
trait Navigation {

  implicit def navigation(implicit coreSubmodules: CoreSubmodules): Seq[NavItem] = {
    Logger.logger.debug("Retrieve navigation for page id = {}", coreSubmodules.page.id)

    createNav(Pages.findParentsForNavigation(coreSubmodules.page.id), coreSubmodules.region)
  }

  private def createNav(pages: Stream[PagesNav], region: Option[Region]) = {
    val navPages =
      pages.map(p => NavItem(p.name, Application.mainPage().url + "?" + Constants.id_pages + "=" + p.id))
    if (region.isDefined) {
      navPages.:+(NavItem(region.get.name, navPages.last.url + "&" + Constants.id_regions + "=" + region.get.id))
    } else {
      navPages
    }
  }

}
