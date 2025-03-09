import sbt._
import scala.meta._

class MyPlugin extends AutoPlugin {

  override def trigger = allRequirements

  object autoImport {
    val printTree = taskKey[Unit]("prints scalameta tree")
  }

  import autoImport._

  override def projectSettings = Seq(
    printTree := {
      def fromFile(filePath: String, fileName: String): Unit = {
        val path = java.nio.file.Paths.get(filePath, fileName)
        val bytes = java.nio.file.Files.readAllBytes(path)
        val text = new String(bytes, "UTF-8")
        val input = Input.VirtualFile(path.toString, text)
        val result = input.parse[Source].get
        println(result)
      }

      fromFile("src/main/scala", "Main.scala")
    }
  )
}
