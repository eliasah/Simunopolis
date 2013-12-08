package temps



import java.util.Timer

class Ticker {
  
  var timer: java.util.Timer= new java.util.Timer
  var task: TickerTask= new TickerTask()
  
  timer.scheduleAtFixedRate(task, 0, 2000)
  

  
  def resetSpeed(speed: Long)= 
  {
    timer.cancel();
    timer= new java.util.Timer()
    
    timer.scheduleAtFixedRate(task,0 , speed)
  }
  
 

}