package simulationMotor

import city.Land

class CurrentCityState(var currentState: CityState) {

  def changeState(newState: CityState) {
    currentState = newState
  }
  def Action = currentState.doAction(this)

  def tax(city: Land) = {
    city.budget increaseBudget (city.getPopulation *
      city.budget.getMoneyTax * city.budget.getPercent / 100)
  }
}