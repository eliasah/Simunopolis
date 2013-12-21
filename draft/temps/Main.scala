object Main {

  def main(args: Array[String]): Unit = {
    
    var ticker :Ticker = new Ticker()
    Thread sleep 4000
    ticker resetSpeed 2000
    Thread sleep 4000
    ticker stop
  }

}
