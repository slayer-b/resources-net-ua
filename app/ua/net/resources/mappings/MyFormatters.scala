package ua.net.resources.mappings

import play.api.data.format.Formatter
import play.api.data._

/**
 * if errors during validation mark it as None.
 * User: slayer
 * Date: 29.07.12
 */
object MyFormatters {

  /**
   * If not exists return None.
   */
  implicit def optionalStringFormat = new Formatter[Option[String]] {
    def bind(key: String, data: Map[String, String]) = Some(data.get(key)).toRight(Nil)
    def unbind(key: String, value: Option[String]) = Map.empty
  }

  /**
   * Default formatter for the `Long` type.
   */
  implicit def optionalLongFormat = new Formatter[Option[Long]] {

    override val format = Some("format.numeric", Nil)

    def bind(key: String, data: Map[String, String]) = {
      Some(data.get(key).flatMap( s =>
        scala.util.control.Exception.allCatch[Long]
          .opt(java.lang.Long.parseLong(s))
      )).toRight(Nil)
    }

    def unbind(key: String, value: Option[Long]) = Map(key -> value.toString)
  }

}

