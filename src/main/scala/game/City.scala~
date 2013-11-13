package game

import scala.collection.mutable.ListBuffer
import overlay._

object City {
  def apply(n: String) = {
    new City(n)
  }
}

class City(n: String) {
  var name: String = n
  var population: Int = 0
  var map: Array[Array[Zone]] = Array.ofDim[Zone](12, 12)
  var layers = new Layers
  var layerManager = new LayerManager(layers)
  var budget = Budget

  def time() = 0

  def addZone(z: Zone, coor : Coordinates): Unit = {
    map(coor.x)(coor.y) = z
    layerManager.applychanges(z,coor.x,coor.y)
    // TODO notifyMS()
  }

  def addWire(): Unit = {}
  
  def removeZone(z: Zone, x: Int, y: Int): Unit = {
    map(x)(y) = null
    // TODO notifyMS()
  }

  def incrementpop(): Unit = {
    population += 1
  }

  def modifname(nname: String): Unit = {
    name = nname
  }

  def printmap(): Unit = {
    for (i <- map) {
      for (j <- i) {
        if (j != null) {
          print(j.toString())

        } else
          print("_")
      }
      println()
    }
  }

  override def toString(): String = {
    var s = "name :" + name + "\n"
    for (z <- map)
      if (z != null) s += z + " "
    return s
  }

}
