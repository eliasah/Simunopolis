package player

import game._
import scala.collection.mutable.HashMap
import time.Time
import enumeration._
import city._

/**
 * @author : Isabelle Richard
 */
abstract class Player(var cityName: String) {

  /**
   * Visiteur
   */
  val visitor = new DisplayZoneVisitor

  /**
   * Ville du joueur
   */
  val city: Land

  /**
   * Gestion de la vitesse du jeu
   */
  def time = city.time
  def slowSpeed = time resetSpeed SpeedType.Slow
  def normalSpeed = time resetSpeed SpeedType.Normal
  def fastSpeed = time resetSpeed SpeedType.Fast
  def stopTimer = time stop

  /**
   * Chargement des couts de construction et destruction
   */
  val prices: HashMap[BuildType.Value, Int]

  /**
   * Reserve une zone dans la ville si le budget est suffisant.
   * @param buildType le type de la zone a reserver
   * @param cc les coordonnees de la zone a reserver
   * @return true si la zone a ete reservee, false sinon
   */
  def reserveZone(buildType: BuildType.Value, c: Coordinates): Boolean

  /**
   * Detruit une zone de la ville si le budget est suffisant.
   * @param c les coordonnees de la zone a detruire
   * @return true si la zone a ete detruite, false sinon
   */
  def destroy(c: Coordinates): Boolean

}
