package ua.net.resources.model

import ua.net.resources.domain._
import play.api.i18n.Lang

/**
 * User: slayer
 * Date: 21.07.12
 */
case class CoreSubmodules(
  siteConfig: SiteConfig,
  counters: Seq[Counter],
  regions: Seq[Region],
  user: Option[User],
  page: Pages
)
