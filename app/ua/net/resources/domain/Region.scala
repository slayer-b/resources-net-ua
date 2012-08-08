package ua.net.resources.domain

import anorm._
import play.api.Play.current
import play.api.db.DB

/**
 * User: slayer
 * Date: 22.07.12
 */
case class Region(id: Long, name: String, sort: Long)

object Region {

  def findById(id: Long) = DB.withConnection { implicit c => {
      SQL("select * from regions where id = {id}")
        .on("id" -> id)()
        .headOption.map(mapRegion)
    }
  }

  def findAllOrdered() = DB.withConnection { implicit c => {
      SQL("select * from regions order by sort")()
        .map(mapRegion).toList
    }
  }

  def findAllOrderedForModule(curReg: Option[Region]) = DB.withConnection { implicit c => {
      val sql = if (curReg.isDefined) {
        SQL("select * from regions where id != {id} order by sort")
          .on("id" -> curReg.get.id)
      } else {
        SQL("select * from regions order by sort")
      }
      sql().map(mapRegion).toList
    }
  }

  def mapRegion(row: SqlRow) =
    Region(row[Long]("id"), row[String]("name"), row[Long]("sort"))

}
