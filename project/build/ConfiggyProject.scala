import sbt._
import com.twitter.sbt._

class ConfiggyProject(info: ProjectInfo) extends StandardProject(info) with SubversionPublisher {
  val json = "com.twitter" %% "json" % "2.1.4"
  val scalaCompiler = "org.scala-lang" % "scala-compiler" % "2.8.1" % "compile"

  // workaround bug in sbt that hides scala-compiler.
  override def filterScalaJars = false

  val specs = "org.scala-tools.testing" %% "specs" % "1.6.6" % "test"

  override def pomExtra =
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      </license>
    </licenses>

  override def subversionRepository = Some("http://svn.local.twitter.com/maven-public")
}
