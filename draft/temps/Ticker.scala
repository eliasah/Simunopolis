package temps

import java.util.Timer
import java.util.TimerTask

class Ticker {
  
  var timer: java.util.Timer= new java.util.Timer
  var task: TickerTask = new TickerTask()
  
  // lancement du timer
  timer.scheduleAtFixedRate(task, 0, 2000)
    
  // changement de la vitesse du timer
  def resetSpeed(speed: Long) = {
    task = new TickerTask()    
    timer.scheduleAtFixedRate(task, 0, speed)
  }
  
}
