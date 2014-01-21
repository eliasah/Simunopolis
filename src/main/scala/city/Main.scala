package city

/**
 * @author Elias Abou Haydar
 *
 */
object Main extends App {
    override def main(args: Array[String]) = {

        val rz1 = ResidentialZone("1")
        val rz2 = ResidentialZone("2")
        val cz3 = CommercialZone("3")

        // Composite Test
        println("Composite without Visitor")
        /*val tree1 = Land(List(Land(List(rz1, rz2, cz3))))
    println("description method call for object tree1")
    tree1.description
    println("------")
    println("description method call for 1st child of tree1")
    tree1.children(0).description
    println("------")

    // Display Visitor Test
    println("Visitor ")
    val v = new DisplayZoneVisitor
    rz1.accept(v)*/
    }
}