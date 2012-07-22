package ua.net.resources.service

import ua.net.resources.domain.Pages
import play.api.db.DB
import anorm._
import play.api.Play.current

/**
 * User: slayer
 * Date: 18.07.12
 */
object PagesService {

  def findMainPage() = {
    Pages(0, "0", "main")
  }

  def findPage(id: Long) = {
    Pages(id, id.toString, "not-main")
  }

}
