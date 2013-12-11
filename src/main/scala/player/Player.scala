package player

import game._
import scala.io.Source
import scala.collection.mutable.HashMap
import time.Time
import enumeration._
import city._

/**
 * author : Isabelle Richard
 */
class Player(cityName: String) {
  //A REVOIR 
  /**
   * Commande des destructions et construction
   */

  /**
   * Chargement des couts de construction et destruction.
   */

  val budget = new Budget(20000) // initiale budget
  val prices = new HashMap[String, Int]
  prices += ("Commerce" -> 100)
  prices += ("Industry" -> 200)
  prices += ("House" -> 200)
  /*Source.fromFile("conf/prices.conf").getLines.foreach {
    line =>
      val words = line.split(" ")
      val zoneType: String = words(0)
      val price: Int = new Integer(words(1))
      prices += (zoneType -> price)
  }*/
  val visitor = new DisplayZoneVisitor
  val city = Land(List())
  val time = new Time
  /**
   * Reserve une zone dans la ville si le budget est suffisant.
   * @param z la zone a ajouter
   * @param c les coordonnees de la zone a ajouter
   * @return true si la zone a ete ajoutee, false sinon
   */
  def reserveZone(z: BuildType.Value, c: Coordinates): Boolean = {
    val price = prices(
      z match {
        case BuildType.Commerce => "Commerce"
        case BuildType.Industry => "Industry"
        case BuildType.House => "House"
      })
    println(price)
    if (this.budget canPay price) {
      this.budget pay price;
      z match {
        case BuildType.Commerce => {
          val tmp = CommercialZone("")
          tmp.accept(visitor)
          city.addChild(tmp)
          city.description
        }
        case BuildType.Industry => {
          val tmp = IndustrialZone("")
          tmp.accept(visitor)
          city.addChild(tmp)
          city.description
        }
        case BuildType.House => {
          val tmp = ResidentialZone("")
          tmp.accept(visitor)
          city.addChild(tmp)
          city.description
        }
      }
      return true
    }

    return false
  }

  /**
   * Detruit une zone de la ville si le budget est suffisant.
   * @param c les coordonnees de la zone a detruire
   * @return true si la zone a ete detruite, false sinon
   */
  def destroy(c: Coordinates): Boolean = {
    val price = prices("destruction")
    if (this.budget canPay price)
      // FIX ME 
      println("Destroy")
    return false
  }

  def slowDown() = time.slowDown()

  def speedUp() = time.speedUp()

}