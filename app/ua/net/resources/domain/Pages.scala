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
case class PagesNav(id: Long, name: String)

object Pages {

  def findMainPage() = DB.withConnection { implicit c => {
      Logger.debug("Retrieving main page")
      SQL("select * from pages where id_pages is null and active = true")()
        .headOption.map(mapPages).get
    }
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

  def findParentsForNavigation(id: Long) = DB.withConnection { implicit c => {
      SQL("""
            WITH RECURSIVE included_pages(id, id_pages, name_ru) AS (
                            SELECT id, id_pages, name_ru FROM pages WHERE active = true and id = {id}
                          UNION ALL
                            SELECT p.id, p.id_pages, p.name_ru
                            FROM included_pages pr, pages p
                            WHERE p.id = pr.id_pages
                          )
                        SELECT id, name_ru
                        FROM included_pages
          """)
        .on("id" -> id)()
        .map(mapPagesNavigation)
        .reverse
    }
  }

  def mapPages(row: SqlRow) =
    Pages(row[Long]("id"), row[String]("name_ru"), row[String]("type"),
      row[String]("title_ru"), row[String]("keywords_ru"), row[String]("description_ru"),
      row[String]("info_top_ru"), row[String]("info_bottom_ru"),
      row[Boolean]("active"), row[Long]("sort"), row[Option[Long]]("id_pages")
    )

  def mapPagesNavigation(row: SqlRow) =
    PagesNav(
      row[Long]("id"), row[String]("name_ru")
    )
}
