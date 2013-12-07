package city

abstract class ZoneState(s: AnyRef { def changeState(s: ZoneState) }) {
  def operation
}

class Catastrophy(s: { def changeState(s: ZoneState) }) extends ZoneState(s) {
  def operation = println(" Catastrophe "); s.changeState(new Calm(s))
}
class Calm(s: { def changeState(s: ZoneState) }) extends ZoneState(s) {
  def operation = println(" Calme "); s.changeState(new Catastrophy(s))
}