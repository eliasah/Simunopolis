package model

class ResidentialZone(x: Int, y: Int) extends Zone {
    coordx = x
    coordy = y

  override def toString(): String = {
    return "R"
  }
}
