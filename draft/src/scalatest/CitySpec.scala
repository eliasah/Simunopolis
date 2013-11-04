package scalatest

import org.scalatest._
import model.City
import model.ResidentialZone

class CitySpec extends FlatSpec with BeforeAndAfter {
  var c : City = _
  var rz : ResidentialZone = _

  before {
	c = City.apply("SmallVille")
    rz = new ResidentialZone(2, 2)
  }

  "A City" should "initialise a map along with the rest of its property" in {
    assert(c.name === "SmallVille")
    assert(c.population === 0)
  }

  "addZone method" should "add a zone the City" in {
    c.addZone(rz)
    assert(!c.map.isEmpty)
  }

  "printMap method" should "show the map of the city" in {
    c.printmap
  }

  ignore should "population++" in {
    c.incrementpop()
    assert(c.population === 1)
  }

}