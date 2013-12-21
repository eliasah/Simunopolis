class TickerTask(val i: Int) extends java.util.TimerTask {
  
  override def run() {
    println(i)
  }

}
