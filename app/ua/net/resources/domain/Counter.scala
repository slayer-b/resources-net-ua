package ua.net.resources.domain

import anorm._
import play.api.Play.current
import play.api.db.DB

/**
 * User: slayer
 * Date: 21.07.12
 */
case class Counter(
  id: Long,
  name: String,
  text: String,
  sort: Long,
  active: Boolean)

object Counter {

  def findAll() = DB.withConnection { implicit c => {
      SQL("select * from counters")()
        .map(mapCounter).toList
    }
  }

  def findAllActiveOrdered() = DB.withConnection { implicit c => {
      SQL("select * from counters where active = '1' order by sort")()
        .map(mapCounter).toList
    }
  }

  def mapCounter(row: SqlRow) =
    Counter(row[Long]("id"), row[String]("name"), row[String]("text"), row[Long]("sort"), row[Boolean]("active"))

}
