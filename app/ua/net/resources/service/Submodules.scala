package ua.net.resources.service

import ua.net.resources.domain.{Pages, SiteConfig, Region, Counter}
import ua.net.resources.model.CoreSubmodules

/**
 * User: slayer
 * Date: 21.07.12
 */

trait Submodules {

  implicit def coreSubmodules(implicit page: Pages) = CoreSubmodules(
      SiteConfig.find(),
      Counter.findAllActiveOrdered(),
      Region.findAllOrdered(),
      None,
      page
  )

}
