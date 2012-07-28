package ua.net.resources.domain

/**
 * User: slayer
 * Date: 18.07.12
 */
case class Pages(id: Long, name: String, kind: String, title: String, keywords: String, description: String)

object Pages {
  def findMainPage() = {
    Pages(0, "0", "Page main", "Page main title", "Page main keywords", "Page main description")
  }

  def findPage(id: Long) = {
    Pages(id, id.toString, "Page not-main", "Page not-main title", "Page not-main keywords", "Page not-main description")
  }
}