package overlay
import game._
import scala.collection.mutable.ListBuffer

class ElectricalLayer {
  type Wire = Pair[Zone, Zone]

  var production: ListBuffer[Zone] = ListBuffer()
  var reception: ListBuffer[Zone] = ListBuffer()
  var wires: ListBuffer[Wire] = ListBuffer()

  def addZone(z: Zone): Unit = {
    if (z.isInstanceOf[PowerPlant]) {
      production += z
    } else {
      reception += z
    }
  }

  def addWire(coorBegin:Coordinates,coorEnd:Coordinates): Unit = {}

  override def toString: String = {
    return "P :" + production.toString + "\n" + "R: " + reception + "\n"
  }
}