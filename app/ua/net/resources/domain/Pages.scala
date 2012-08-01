package ua.net.resources.domain

import play.Logger
import anorm._
import play.api.Play.current
import play.api.db.DB

/**
 * User: slayer
 * Date: 18.07.12
 */
case class Pages(id: Long, name: String, kind: String, title: String, keywords: String, description: String,
                  infoTop: String, infoBottom: String,
                  active: Boolean, sort: Long, id_pages: Option[Long])

object Pages {

  def findMainPage() = {
    Logger.debug("Retrieving main page")
    Pages(0, "0", "Page main", "Page main title", "Page main keywords", "Page main description",
      "Info top", "Info bottom", true, 0, None)
  }

  def findById(id: Long) = DB.withConnection { implicit c => {
      SQL("select * from pages where id = {id}")
        .on("id" -> id)()
        .headOption.map(mapPages)
    }
  }

  def findByIdOrElseMainPage(id: Option[Long]) = DB.withConnection { implicit c => {
      id.flatMap(findById(_)).getOrElse(findMainPage())
    }
  }

  def mapPages(row: SqlRow) =
    Pages(row[Long]("id"), row[String]("name_ru"), row[String]("type"),
      row[String]("title_ru"), row[String]("keywords_ru"), row[String]("description_ru"),
      row[String]("info_top_ru"), row[String]("info_bottom_ru"),
      row[Boolean]("active"), row[Long]("sort"), row[Option[Long]]("id_pages")
    )
}
