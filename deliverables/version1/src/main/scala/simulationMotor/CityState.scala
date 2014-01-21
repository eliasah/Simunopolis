package simulationMotor

import city.Land

/**
 * @author Christian Chiev
 *
 */
abstract class CityState {
	def doAction(state:CurrentCityState);
}