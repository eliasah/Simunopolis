package model

object Main extends App {
  override def main(args: Array[String]) {
    val c = City.apply("Smallville")
    val rz = new ResidentialZone
    val pp = new PowerPlant
    // println(rz.coordx,rz.coordy)

    c.addZone(rz, 2, 2)
    c.addZone(pp,5,5)
    c.printmap()
    
    println(c.layers.eleclay.toString)
    
  }
}
