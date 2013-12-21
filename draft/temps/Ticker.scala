import java.util.Timer
import java.util.TimerTask

class Ticker {
  
  var i: Int = 1
  var timer: java.util.Timer = new java.util.Timer
  var task: TickerTask = new TickerTask(i)
  
  // lancement du timer
  timer scheduleAtFixedRate(task, 0, 1000)

  // arretdu timer
  def stop = timer cancel
  
  // changement de la vitesse du timer
  def resetSpeed(speed: Long) = {
    i += 1
    task = new TickerTask(i)
    timer scheduleAtFixedRate(task, 0, speed)
  }
  
}
