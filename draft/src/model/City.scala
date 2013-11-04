package simunopolis

import scala.collection.mutable.ArrayBuffer
import scala.swing.model.Matrix

class City(n: String) {
  val name: String = n
  var population: Int = 0
  def budget(): Double = 20000
  def time() = 0
  def zones = Array.ofDim[Zone](3,4)

  override def toString(): String = {
    var s = "name :" + name + "\n"
    for (z <- zones)
      if (z != null) s += z + " "
    return s
  }

  def addZone(z: Zone): Unit = {
    val x = z.getx()
    val y = z.gety()
    zones(x)(y) = z
    // TODO notifyMS()
  }

  def removeZone(z: Zone): Unit = {
    val x = z.getx()
    val y = z.gety()
    zones(x)(y) = null
    // TODO notifyMS()
  }

  def incrementepop(): Unit = {
    population = population + 1
  }

}
