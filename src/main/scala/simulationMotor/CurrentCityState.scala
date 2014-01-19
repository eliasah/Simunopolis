package simulationMotor

class CurrentCityState(var currentState: CityState) {

  def changeState(newState: CityState) {
    currentState = newState
  }
  def Action = currentState.doAction(this)
}