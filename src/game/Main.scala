package game

object Main extends App {
  override def main(args: Array[String]) {
    val c = City.apply("Smallville")
    val rz = new ResidentialZone
    val pp = new PowerPlant
    // println(rz.coordx,rz.coordy)

    c.addZone(rz, new Coordinates(2,2))
    c.addZone(pp, new Coordinates(5,5))
    c.printmap()
    
    println(c.layers.eleclay.toString)
    
  }
}
