package example

import scala.meta._

object Hello extends Greeting with App {
  def fromFile(filePath: String, fileName: String): Unit = {
    val path = java.nio.file.Paths.get(filePath, fileName)
    val bytes = java.nio.file.Files.readAllBytes(path)
    val text = new String(bytes, "UTF-8")
    val input = Input.VirtualFile(path.toString, text)
    val result = input.parse[Source].get
    println(result)
  }

  fromFile("/Users/mack.solomon/sandbox/scalameta-example/src/main/scala/example", "Test.scala")
}

trait Greeting {
  lazy val greeting: String = "hello"
}
