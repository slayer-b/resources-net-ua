package ua.net.resources.service

import ua.net.resources.domain.{Region, Counter}
import ua.net.resources.model.CoreSubmodules

/**
 * User: slayer
 * Date: 21.07.12
 */

trait Submodules {

  implicit def coreSubmodules =
    CoreSubmodules(Counter.findAllActiveOrdered(), Region.findAllOrdered(), None)

}
