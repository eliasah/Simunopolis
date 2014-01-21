package simulationMotor

import city.Land

/**
 * @author Christian Chiev
 *
 */
class CrimeState(city: Land) extends CityState {
  override def doAction(state: CurrentCityState) = {
    var total = ((city.getPopulation.asInstanceOf[Int] * 2 / 100) + 1)
    if (total > city.getPopulation)
      city.setPopulation(0)
    else
      city.setPopulation(city.getPopulation - total)
    if (city.police * 24 > city.getPopulation)
      state.changeState(new PeacefulState(city))
    state tax city
  }
}