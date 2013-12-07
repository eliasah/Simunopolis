package city

sealed abstract class Zone {
  var density: Int = 0
  var value: Int = 0
  var crime: Int = 0
  var pollution: Int = 0
  var growth: Int = 0

  def description

}

abstract class LeafZone extends Zone() {}

case class ResidentialZone(var d: String) extends LeafZone {
  def description = println("Residential Zone " + d)
}
case class CommercialZone(var d: String) extends LeafZone {
  def description = println("Commercial Zone " + d)
}
case class Land(var children: List[Zone]) extends Zone {
  def description = children.foreach(x => x.description)
}

object Main extends App {
  override def main(args: Array[String]) = {

    val tree = Land(List(Land(List(ResidentialZone("1"), CommercialZone("2"))), ResidentialZone("2")))
    tree.description
    println("------")
    tree.children(1).description
  }

}