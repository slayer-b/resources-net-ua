package ua.net.resources.model

import ua.net.resources.domain.{User, Region, Counter}

/**
 * User: slayer
 * Date: 21.07.12
 */
case class CoreSubmodules(
  counters: Seq[Counter],
  regions: Seq[Region],
  user: Option[User]
)
