package player

import game._
import scala.collection.mutable.HashMap
import enumeration._
import city._
import time.Time

/**
 * @author : Isabelle Richard
 */
class Mayor(cityName: String, time: Time) extends Player(cityName, time) {

  val budget = new Budget(20000)
  val prices = new HashMap[BuildType.Value, Int]
  prices += (BuildType.Commerce -> 200)
  prices += (BuildType.House -> 200)
  prices += (BuildType.Industry -> 200)
  prices += (BuildType.PoliceDepartment -> 1000)
  prices += (BuildType.PowerPlant -> 5000)
  prices += (BuildType.Road -> 10)
  prices += (BuildType.Destroy -> 10)

  val city = Land()

  def reserveZone(buildType: BuildType.Value, c: Coordinates): Boolean = {
    val price = prices(buildType)
    if (budget canPay price) {
      val tmp = buildType match {
        case BuildType.Commerce => CommercialZone("")
        case BuildType.Industry => IndustrialZone("")
        case BuildType.House => ResidentialZone("")
        case BuildType.PowerPlant => PowerPlant()
        case BuildType.PoliceDepartment => PoliceDepartment()
      }
      tmp accept (visitor)
      //city.addChild(tmp)
      if (city add (tmp, c)) {
        budget pay price
        return true
      }
    }
    return false
  }

  def destroy(c: Coordinates): Boolean = {
    val price = prices(BuildType.Destroy)
    if (budget canPay price) {
      if (city del c) {
        budget pay price
        return true
      }
    }
    return false
  }

}
