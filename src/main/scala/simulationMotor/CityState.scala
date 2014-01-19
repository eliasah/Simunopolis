package simulationMotor

import city.Land

abstract class CityState {
	def doAction(state:CurrentCityState);
}