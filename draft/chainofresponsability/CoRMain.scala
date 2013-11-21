package chainofresponsability

object CoRMain extends App {

  override def main(args: Array[String]) = {
    val sensor = new Sensor
    val display1 = new Display1
    val display2 = new Display2 with Display2Handler
    sensor.successor = display1
    display1.successor = display2
    sensor.changeValue(2)
    sensor.changeValue(4)
  }
}