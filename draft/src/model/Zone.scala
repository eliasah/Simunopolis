package model

abstract class Zone extends ZoneActions {

  var density: Int = 0
  var value: Int = 0
  var crime: Int = 0
  var pollution: Int = 0
  var growth: Int = 0
  var coordx: Int = 0
  var coordy: Int = 0

  def apply(x: Int, y: Int) = {
    coordx = x
    coordy = y
  }

  def getx(): Int = {
    coordx
  }
  
  def gety(): Int = {
    coordy
  }

}