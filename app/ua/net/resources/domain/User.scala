package ua.net.resources.domain

/**
 * User: slayer
 * Date: 22.07.12
 */
case class User(id: Long, login: String, name: String)

object User {

  def findByLogin(login: String) {
    User(0, login, login)
  }

}
