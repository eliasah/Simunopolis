package timer



object Main {

  def main(args: Array[String]): Unit = {
    
    var ticker = new Ticker
    
    Thread sleep 2000
    ticker resetSpeed 500
    Thread sleep 2000
    ticker resetSpeed 2000
    Thread sleep 5000
    ticker stop
  }

}