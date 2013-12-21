package player

import game._
import scala.io.Source
import scala.collection.mutable.HashMap
import time.Time
import enumeration._
import city._

/**
 * @author : Isabelle Richard
 */
class Player(var cityName: String) {

  /**
   * Gestion de la vitesse du jeu
   */
  val time = new Time  
  def slowSpeed = time changeSpeed SpeedType.Slow
  def normalSpeed = time changeSpeed SpeedType.Normal
  def fastSpeed = time changeSpeed SpeedType.Fast
  def stopTimer = time stop

  /**
   * Budget initial du joueur
   */
  val budget = new Budget(20000)

  /**
   * Chargement des couts de construction et destruction
   */
  val prices = new HashMap[BuildType.Value, Int]
  prices += (BuildType.Commerce -> 100)
  prices += (BuildType.House -> 200)
  prices += (BuildType.Industry -> 200)
  prices += (BuildType.Road -> 10)
  prices += (BuildType.Destroy -> 10)

  val visitor = new DisplayZoneVisitor

  /**
   * Ville du joueur
   */
  val city = Land(List())

  /**
   * Reserve une zone dans la ville si le budget est suffisant.
   * @param buildType le type de la zone a reserver
   * @param cc les coordonnees de la zone a reserver
   * @return true si la zone a ete reservee, false sinon
   */
  def reserveZone(buildType: BuildType.Value, c: Coordinates): Boolean = {
    val price = prices(buildType)
    if (this.budget canPay price) {
      this.budget pay price;
      buildType match {
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
        // TODO ajouter les autres types de zones reservables
      }
      // TODO deduire l'argent utilise du budget du joueur
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
    val price = prices(BuildType.Destroy)
    if (this.budget canPay price)
      // TODO
      println("Destroy")
    return false
  }

}
