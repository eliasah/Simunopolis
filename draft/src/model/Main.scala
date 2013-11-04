package simunopolis

object Main extends App {

  override def main(args: Array[String]) {

    val c = new City("Smallville")
    val rz = new ResidentialZone(1,1)

    c.addZone(rz)
    
    println(c)
  }

}