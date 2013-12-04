package player

import game._
import scala.io.Source
import scala.collection.mutable.HashMap
import time.Time

/**
 * author : Isabelle Richard
 */
class Player(cityName: String) {
  //A REVOIR 
  /** 
   * Commande des destructions et construction 
   */
  abstract class Command
  case class Empty extends Command
  case class House extends Command
  case class Commerce extends Command
  case class Industry extends Command
  case class Road extends Command
  case class Destroy extends Command
  /**
   * Chargement des couts de construction et destruction.
   */
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

  val city = City.apply(cityName)
  val time = new Time

  /**
   * Reserve une zone dans la ville si le budget est suffisant.
   * @param z la zone a ajouter
   * @param c les coordonnees de la zone a ajouter
   * @return true si la zone a ete ajoutee, false sinon
   */
  def reserveZone(z: Command, c: Coordinates): Boolean = {
    val price = prices(z match {
      case cz: Commerce => "Commerce"
      case iz: Industry => "Industry"
      case rz: House => "House"
    })
    println(price)
    if (city.budget canPay price) {
      city.budget pay price
      println("Appel Abstract Constructuin a faire pour "+z+" !!!!!!!!")
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
    if (city.budget canPay price)
      return city destroyZone (c)
    return false
  }

  def slowDown() = time.slowDown()

  def speedUp() = time.speedUp()

}