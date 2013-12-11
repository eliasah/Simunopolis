package temps

object Main {

  def main(args: Array[String]): Unit = {
    
    var ticker :Ticker = new Ticker()
    Thread.sleep(3000)
    ticker resetSpeed(500)
    Thread.sleep(2000)
    ticker resetSpeed(100)
    
  }

}
