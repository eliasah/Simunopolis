package player

import game._
import scala.io.Source
import scala.collection.mutable.HashMap
import time.Time

class Player(cityName: String) {

  /**
   * Chargement des couts de construction et destruction.
   */
  val prices = new HashMap[String, Int]
  Source.fromFile("conf/prices.conf").getLines.foreach {
    line =>
      val words = line.split(" ")
      val zoneType: String = words(0)
      val price: Int = new Integer(words(1))
      prices += (zoneType -> price)
  }

  val city = City.apply(cityName)
  val time = new Time

  /**
   * Reserve une zone dans la ville si le budget est suffisant.
   * @param z la zone a ajouter
   * @param c les coordonnees de la zone a ajouter
   * @return true si la zone a ete ajoutee, false sinon
   */
  def reserveZone(z: Zone, c: Coordinates): Boolean = {
    val price = prices(z match {
      case cz: CommercialZone => "commercial"
      case iz: IndustrialZone => "industrial"
      case rz: ResidentialZone => "residential"
    })
    if (city.budget canPay price)
      return city addZone (z, c)
    return false
  }

  /**
   * Detruit une zone de la ville si le budget est suffisant.
   * @param c les coordonnees de la zone a detruire
   * @return true si la zone a ete detruite, false sinon
   */
  def destroy(c: Coordinates): Boolean = {
    val price = prices("destruction")
    if (city.budget canPay price)
      return city destroyZone (c)
    return false
  }
  
  def slowDown() = time.slowDown()
  
  def speedUp() = time.speedUp()

}