package city

object Main extends App {
  override def main(args: Array[String]) = {

    // Composite Test
    println("Composite ")
    val tree1 = Land(List(Land(List(ResidentialZone("1"), CommercialZone("2"))), ResidentialZone("2")))
    println("description method call for object tree1")
    tree1.description
    println("------")
    println("description method call for 1st child of tree1")
    tree1.children(1).description
    println("------")

    // Display Visitor Test
    println("Visitor ")
    val s = Catastrophe()
    val rz1 = ResidentialZone
    val rz2 = ResidentialZone
    val cz3 = CommercialZone

    val tree2 = Land(List(rz1, rz2, cz3))
    val v = new DisplayZoneVisitor
    tree2.accept(v)
    println("------")
  }
}