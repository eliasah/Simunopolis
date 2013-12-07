package city

abstract class Zone(s: { def changeState(s: ZoneState) }) extends ZoneState(s) {
  var density: Int = 0
  var value: Int = 0
  var crime: Int = 0
  var pollution: Int = 0
  var growth: Int = 0

  def description
  def accept(v: ZoneVisitor)
}

abstract class LeafZone(s: { def changeState(s: ZoneState) }) extends Zone(s) {
  def changeState(s: ZoneState) = println("change")
}

case class ResidentialZone(s: { def changeState(s: ZoneState) })(var d: String) extends LeafZone(s) {
  def description = println("Residential Zone " + d)
  def accept(v: ZoneVisitor) = v visit this
  def operation = println("opR")
}
case class CommercialZone(s: { def changeState(s: ZoneState) })(var d: String) extends LeafZone(s) {
  def description = println("Commercial Zone " + d)
  def accept(v: ZoneVisitor) = v visit this
  def operation = println("opC")
}

case class IndustrialZone(s: { def changeState(s: ZoneState) })(var d: String) extends LeafZone(s) {
  def description = println("IndustrialZone" + d)
  def accept(v: ZoneVisitor) = v visit this
  def operation = println("opI")
}