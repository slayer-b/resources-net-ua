package ua.net.resources.domain

/**
 * User: slayer
 * Date: 09.08.12
 */
case class Site(id: Long, id_users: Long, id_pages: Long, id_regions: Long,
                title: String, description: String, info: String, keywords:String,
                url: String, back_url: String, sort: Long, email: String)
