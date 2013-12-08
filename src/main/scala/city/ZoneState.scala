package city

abstract class ZoneState(s: ZoneState { def changeState(s: ZoneState) }) {
  def operation
}

class Catastrophy(s: ZoneState { def changeState(s: ZoneState) })
  extends ZoneState(s) {
  def operation = println(" Catastrophy "); s.changeState(new Calm(s))
}
class Calm(s: ZoneState { def changeState(s: ZoneState) })
  extends ZoneState(s) {
  def operation = println(" Calm "); s.changeState(new Catastrophy(s))
}