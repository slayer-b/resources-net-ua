package ua.net.resources.service

import ua.net.resources.domain._
import ua.net.resources.model.CoreSubmodules
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
      None,
      Site.findByMaxSort()
  )

}
