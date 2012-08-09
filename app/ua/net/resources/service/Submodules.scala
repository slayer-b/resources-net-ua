package ua.net.resources.service

import ua.net.resources.domain.{Pages, SiteConfig, Region, Counter}
import ua.net.resources.model.CoreSubmodules

/**
 * User: slayer
 * Date: 21.07.12
 */

object Submodules {

  def coreSubmodules(page: Pages, region: Option[Region]) = CoreSubmodules(
      SiteConfig.find(),
      Counter.findAllActiveOrdered(),
      Region.findAllOrderedForModule(region),
      None,
      page,
      region,
      None
  )

}
