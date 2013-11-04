package model

object Main extends App {
  override def main(args: Array[String]) {
    val c = City.apply("Smallville")
    val rz = new ResidentialZone(2,2)
    // println(rz.coordx,rz.coordy)

    c.addZone(rz)
    
    c.printmap()
  }
}
