package city

/**
 * @author Elias Abou Haydar
 *
 */
abstract class ZoneState(z: Zone) {
    def changeState(s: ZoneState)
    def operation
}

/*class Catastrophy(z: Zone) extends ZoneState(z) {

  def changeState(s: ZoneState) = println("Catastrophy state")
  def operation { println(" Catastrophy "); }
}

class Calm(z: Zone) extends ZoneState(z) {
  def changeState(s: ZoneState) = println("Calm state")
  def operation = println(" Calm ");
}*/