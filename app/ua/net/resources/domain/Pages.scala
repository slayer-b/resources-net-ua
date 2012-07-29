package ua.net.resources.domain

import play.Logger

/**
 * User: slayer
 * Date: 18.07.12
 */
case class Pages(id: Long, name: String, kind: String, title: String, keywords: String, description: String)

object Pages {

  def findMainPage() = {
    Logger.debug("Retrieving main page")
    Pages(0, "0", "Page main", "Page main title", "Page main keywords", "Page main description")
  }

  def findPage(id: Long) = {
    Logger.debug("Retrieving page id = " + id)
    Pages(id, id.toString, "Page not-main", "Page not-main title", "Page not-main keywords", "Page not-main description")
  }
}