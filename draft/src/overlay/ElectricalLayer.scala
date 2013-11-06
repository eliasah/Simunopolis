package overlay
import model._
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

  def addWire(x1:Int,y1:Int,x2:Int,y2:Int): Unit = {}

  override def toString: String = {
    return "P :" + production.toString + "\n" + "R: " + reception + "\n"
  }
}