package ua.net.resources.domain

import anorm._
import play.api.Play.current
import play.api.db.DB

/**
 * User: slayer
 * Date: 09.08.12
 */
case class Site(id: Long, id_users: Long, id_pages: Long, id_regions: Long,
                title: String, description: String, info: String, keywords:String,
                url: String, back_url: String, sort: Long, email: String)

object Site {

  def findByIdPagesForModule(id_pages: Long) = DB.withConnection { implicit c => {
      SQL("select * from sites where id_pages = {id_pages} order by sort")
        .on("id_pages" -> id_pages)()
        .map(mapSite).toList
    }
  }

  def mapSite(row: SqlRow) =
    Site(row[Long]("id"), row[Long]("id_users"), row[Long]("id_pages"), row[Long]("id_regions"),
        row[String]("title_ru"), row[String]("description_ru"), row[String]("info_ru"), row[String]("keywords_ru"),
        row[String]("url"), row[String]("back_url"), row[Long]("sort"), row[String]("email"))
}