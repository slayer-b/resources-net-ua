package ua.net.resources.mappings

import play.api.data.format.Formatter
import play.api.data.FieldMapping

/**
 * My own form mappings.
 * Didn't found a way to return None, if any errors in standard libraries.
 * User: slayer
 * Date: 31.07.12
 */
object MyForms {


  import MyFormatters._

  /**
   * Creates a Mapping of type `T`.
   *
   * For example:
   * {{{
   * Form("email" -> of[String])
   * }}}
   *
   * @tparam T the mapping type
   * @return a mapping for a simple field
   */
  def of[T](implicit binder: Formatter[T]): FieldMapping[T] = FieldMapping[T]()(binder)

  /**
   * If any errors or field is empty return None
   * else return Some[Long]
   */
  def optionalLongNumber = of[Option[Long]]

}
