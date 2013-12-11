package city

abstract class ZoneState(z: Zone) {
  def changeState(s: ZoneState)
  def operation
}

class Catastrophy(z: Zone) extends ZoneState(z) {

  def changeState(s: ZoneState) = println("change to catastrophy")
  def operation { println(" Catastrophy "); }
}

class Calm(z: Zone) extends ZoneState(z) {
  def changeState(s: ZoneState) = println("blablabla")
  def operation = println(" Calm ");
}