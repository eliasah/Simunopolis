package scalatest

import org.scalatest._
import game.ResidentialZone
import game.City


class CitySpec extends FlatSpec with BeforeAndAfter {
  var c: City = _
  var rz: ResidentialZone = _

  before {
    c = City.apply("SmallVille")
  }

  "A City" should "initialise a map along with the rest of its property" in {
    assert(c.name === "SmallVille")
    assert(c.population === 0)
  }

  "ResidentialZone" should "initialise a residential zone" in {
    rz = new ResidentialZone()
    assert(rz.pollution === 1)
    assert(rz.density === 20)
    assert(rz.value === 100)
  }

  "addZone(rz : ResidentialZone) method" should "add a zone the City" in {
    c.addZone(rz, 2, 2)
    assert(!c.map.isEmpty)
  }

  "printmap" should "show the map of the city" in {
    rz = new ResidentialZone()
    c.addZone(rz, 2, 2)
    c.printmap
  }

  "incrementpops" should "population++" in {
    c.incrementpop()
    assert(c.population === 1)
  }

}