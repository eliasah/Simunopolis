package timer

class Ticker {
  

  
  var speedInit:Long = 2000
  var task: TickerTask = new TickerTask(2000)
  var timer: java.util.Timer = new java.util.Timer
  
  timer scheduleAtFixedRate(task, 0, 2000)
  
  
  def resetSpeed(speed:Long){
   
    timer cancel
    
    timer = new java.util.Timer

    task = new TickerTask(speed)
    timer scheduleAtFixedRate(task, 0, speed)
  }
  
  def stop(){
    timer.cancel()
  }
}