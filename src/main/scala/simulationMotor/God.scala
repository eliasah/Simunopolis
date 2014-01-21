package simulationMotor

import city.Land
import city.Observer
import city.Subject
import city.Zone
import player._
import time.Observer
import time.Subject
import time.Time
import city.Subject

/**
 * @author Isabelle Richard
 *
 */
class God(var mycity: Land) extends time.Observer with city.Observer {
    var state: CurrentCityState = new CurrentCityState(new PeacefulState(mycity))

    def onNotify(s: time.Subject) = s match {
        case time: Time => action
    }
    def onNotify(s: city.Subject) = s match {
        case land: Land => // FIXME
            println("God notifié par Zone")
    }

    /**
     * Enregistrement de God comme observateur du temps du joueur
     */
    mycity.time.register(this)
    mycity.register(this)

    def action() = state.action
}