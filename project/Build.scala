import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "resources-catalogue"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
//      "postgresql" % "postgresql" % "8.4-702.jdbc4"
        "mysql" % "mysql-connector-java" % "5.1.18"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here
    )

}
