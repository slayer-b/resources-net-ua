package ua.net.resources.domain

import anorm._
import play.api.Play.current
import play.api.db.DB

/**
 * User: slayer
 * Date: 09.08.12
 */
case class Site(id: Long, id_users: Option[Long], id_pages: Long, id_regions: Long,
                title: String, description: String, info: String, keywords:String,
                url: String, back_url: String, sort: Long, email: String)

object Site {

  def findByIdPagesForModule(id_pages: Long) = DB.withConnection { implicit c => {
      SQL("select * from sites where id_pages = {id_pages} order by sort")
        .on("id_pages" -> id_pages)()
        .map(mapSite).toList
    }
  }

  def findByMaxSort() = DB.withConnection { implicit c => {
      SQL("select * from sites where sort = (select max(sort) from sites) limit 1")()
        .headOption.map(mapSite).get
    }
  }

  def increaseSortBy(url: String) = DB.withConnection { implicit c => {
      SQL("update sites set sort = sort + 1 where url like '%{url}%'")
        .on("url" -> url)
        .executeUpdate()
    }
  }

  def mapSite(row: SqlRow) =
    Site(row[Long]("id"), row[Option[Long]]("id_users"), row[Long]("id_pages"), row[Long]("id_regions"),
        row[String]("title_ru"), row[String]("description_ru"), row[String]("info_ru"), row[String]("keywords_ru"),
        row[String]("url"), row[String]("back_url"), row[Long]("sort"), row[String]("email"))
}