package simulationMotor

import city.Land
import city.Zone

class DisasterState(city: Land) extends CityState {

  override def doAction(state: CurrentCityState) = {
    var destroy: Int = (city.totalZone * 5 / 100).asInstanceOf[Int] + 1
    var i = 0
    for (y <- 0 until city.table.data.length if i <= destroy)
      for (z <- 0 until city.table.data(y).length if i <= destroy) {
        destroy += 1
        city.table.data(y)(z) = null
      }
    state.changeState(new PeacefulState(city))
    state tax city
  }
}