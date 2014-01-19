package simulationMotor

import city.Land
import city.Observer
import city.Subject
import city.Zone
import player._
import time.Observer
import time.Subject
import time.Time

class God(var mayor: Mayor) extends time.Observer with city.Observer {

    def onNotify(s: time.Subject) = s match {
        case time: Time => // FIXME
            increaseDensity
    }
    def onNotify(s: city.Subject) = s match {
        case land: Land => // FIXME
            println("God notifié par Zone")
    }

    /**
     * Enregistrement de God comme observateur du temps du joueur
     */
    mayor.time.register(this)
    mayor.city.register(this)

    def increaseDensity() = mayor.city.increaseDensity(1)
    def decreaseDensity() = mayor.city.decreaseDensity(1)
}