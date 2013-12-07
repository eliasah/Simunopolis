package city

case class Land(s: { def changeState(s: ZoneState) })(var children: List[Zone]) extends Zone(s) {
  def description = children.foreach(x => x.description)
  def accept(v: ZoneVisitor) = v visit this
  def operation = println("opL")
}