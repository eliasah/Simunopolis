package simulationMotor

import city.Land

class PeacefulState(city: Land) extends CityState {
  override def doAction(state: CurrentCityState) = {
    var total = city.getPopulation + (city.getPopulation.asInstanceOf[Int] * 10 / 100) + 1

    if (total > city.getMax)
      city.setPopulation(city.getMax)
    else
      city.setPopulation(total)

    if (city.police * 24 < city.getPopulation)
      state.changeState(new CrimeState(city))
    state tax city
  }
}