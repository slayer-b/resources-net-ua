package ua.net.resources.domain

import anorm._
import play.api.Play.current
import play.api.db.DB

/**
 * User: slayer
 * Date: 27.07.12
 */
case class SiteConfig (
  id: Long,
  name: String,
  title: String
)

object SiteConfig {

  //TODO: make caching
  def find() = DB.withConnection { implicit c => {
      SQL("select * from site_config")()
        .headOption.map(mapSiteConfig).get
    }
  }

  def mapSiteConfig(row: SqlRow) =
    SiteConfig(row[Long]("id"), row[String]("site_name_ru"), row[String]("title_text_ru"))

}