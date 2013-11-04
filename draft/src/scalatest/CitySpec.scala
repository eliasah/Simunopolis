package scalatest

import org.scalatest._
import simunopolis.City
import simunopolis.ResidentialZone

class CitySpec extends FlatSpec {
  val c = new City("MyCity")

  "A City" should "initialise a map along with the rest of its property" in {
    assert(c.name === "MyCity")
    assert(c.population === 0)
  }

  it should "addZone()" in {
    var z = new ResidentialZone(1,1)
    c.addZone(z)
    assert(!c.zones.isEmpty)
    assert(c.zones(1)(1) === z)
  }
  
  it should "population++" in {
    c.incrementepop()
    assert(c.population === 1)
  }
}