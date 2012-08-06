package ua.net.resources.controllers

import ua.net.resources.model.{NavItem, CoreSubmodules}
import ua.net.resources.domain.Pages
import play.api.Logger

/**
 * User: slayer
 * Date: 06.08.12
 */
trait Navigation {

  implicit def navigation(implicit coreSubmodules: CoreSubmodules): Seq[NavItem] = {
    Logger.logger.debug("Retrieve navigation for page id = {}", coreSubmodules.page.id)

    Pages.findParentsForNavigation(coreSubmodules.page.id)
      .map(p => NavItem(p.name, "" + p.id))
      .toSeq
  }

}
