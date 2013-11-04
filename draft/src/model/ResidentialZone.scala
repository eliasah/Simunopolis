package simunopolis

class ResidentialZone(x: Int, y: Int) extends Zone {

  override def toString(): String = {
    return "Zone Résidentielle située en x = " + coordx + " et y = " + coordy
  }
}
