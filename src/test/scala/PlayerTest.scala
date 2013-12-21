import org.scalatest._
import org.scalatest.AbstractSuite
import org.scalatest.Assertions

import player.Player

/**
 * @author: Isabelle Richard
 */

class PlayerTest extends FlatSpec with BeforeAndAfter {
  var p = new Player("TestCity")

  after {
	  p stopTimer
  }

  "the name of the city" should "be TestCity" in {
    assert(p.cityName == "TestCity")
  }

  "a new city" should "have at least one zone" in {
    assert(p.city.children.size > 0)
  }

}
