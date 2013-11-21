package chainofresponsability

class Sensor extends Handler[Int] {
  var value = 0
  def changeValue(v: Int) {
    value = v
    handleRequest(value)
  }
}




