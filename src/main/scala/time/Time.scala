/*
 * TODO 
 * faire en sorte que Time tourne en permanence, mais que l'on puisse 
 * a tout moment parametrer sa vitesse
 */

package time

class Time extends Runnable {

  abstract class Speed
  case class SlowSpeed extends Speed
  case class NormalSpeed extends Speed
  case class FastSpeed extends Speed

  var speed: Speed = new NormalSpeed
  var year = 2000

  val seconds = 2

  override def run() {
    while (true) {
      val milliseconds = 1000 * (speed match {
        case s: SlowSpeed => seconds * 2
        case s: NormalSpeed => seconds
        case s: FastSpeed => seconds / 2
      })
      Thread sleep (milliseconds)
      year += 1
      // avertir le moteur qu'il doit effectuer les mises à jour sur le modèle
      println(year)
    }
  }

  def slowDown() = speed match {
    case s: NormalSpeed => speed = new SlowSpeed
    case s: FastSpeed => speed = new NormalSpeed
    case s => Unit
  }

  def speedUp() = speed match {
    case s: NormalSpeed => speed = new FastSpeed
    case s: SlowSpeed => speed = new NormalSpeed
    case s => Unit
  }

}

object Main extends App {
  override def main(args: Array[String]) {
    var t = new Time
    t.run
  }
}