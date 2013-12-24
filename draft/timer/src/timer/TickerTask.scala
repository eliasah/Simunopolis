package timer

class TickerTask(val i: Long) extends java.util.TimerTask {
  
  override def run() {
    println("Tick toutes les "+i+" millisecondes")
  }

}
