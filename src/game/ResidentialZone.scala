package game

class ResidentialZone extends Zone {
  density = 20
  value = 100
  pollution = 1
  
  override def toString(): String = {
    return "R"
  }
}
