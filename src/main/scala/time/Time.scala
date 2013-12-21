package time

import java.util.Timer
import java.util.TimerTask
import enumeration.SpeedType

/**
 * @author Isabelle Richard
 */

class Time {

  var year = 2013

  type Milliseconds = Long
  var period: Milliseconds = 1000

  var timer: java.util.Timer = new java.util.Timer

  class TimeTask extends java.util.TimerTask {
    override def run {
      year += 1
      println("TODO: déclencher les mises a jour " +
        "(période=" + period + ", année=" + year + ")")
    }
  }

  timer scheduleAtFixedRate (new TimeTask, 0, period)

  /**
   * Modifie la vitesse de declenchement des taches
   * @param speed vitesse a adopter
   */
  def changeSpeed(speed: SpeedType.Value) {
    period = speed match {
      case SpeedType.Slow => 5000
      case SpeedType.Normal => 1000
      case SpeedType.Fast => 200
    }
    timer scheduleAtFixedRate (new TimeTask, period, period)
    println("La vitesse a été changée: " + period)
  }

  /**
   * Arrete l'execution du timer
   */
  def stop = timer cancel

}

// permet de tester le Timer
object Main extends App {
  override def main(args: Array[String]) {
    var time: Time = new Time
    Thread sleep 2000
    println("Changement de la vitesse...")
    time changeSpeed SpeedType.Slow
    Thread sleep 2000
    println("Arrêt du timer...")
    time stop
  }
}
