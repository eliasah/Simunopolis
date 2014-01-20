package time

import java.util.Timer
import java.util.TimerTask
import enumeration.SpeedType
import simulationMotor.God

/**
 * @author Isabelle Richard
 */

class Time extends Subject {
    class TimeTask extends java.util.TimerTask {
        override def run {
            year += 1
            notifyObservers
        }
    }

    type Milliseconds = Long
    var year = 2013
    val normalPeriod: Milliseconds = 1000
    val delay: Long = 0
    var period: Milliseconds = normalPeriod
    var task: TimerTask = new TimeTask
    var timer: java.util.Timer = new java.util.Timer

    timer scheduleAtFixedRate (task, delay, period)

    /**
     * Modifie la vitesse de declenchement des taches
     * @param speed vitesse a adopter
     */
    def resetSpeed(speed: SpeedType.Value) {
        timer cancel ()
        timer = new java.util.Timer
        period = speed match {
            case SpeedType.Slow => normalPeriod * 5
            case SpeedType.Normal => normalPeriod
            case SpeedType.Fast => normalPeriod / 5
        }
        task = new TimeTask
        timer scheduleAtFixedRate (task, delay, period)
    }

    /**
     * Arrete l'execution du timer
     */
    def stop = timer cancel
}

