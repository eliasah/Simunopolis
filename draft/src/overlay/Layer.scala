package overlay

import model.Zone

abstract class Layer {

  def addZone(z: Zone): Unit
  def addWire(x1: Int, y1: Int, x2: Int, y2: Int): Unit

}