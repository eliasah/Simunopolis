package chainofresponsability

trait Handler[T] {
  var successor: Handler[T] = null

  def handleRequest(r: T): Unit =
    if (handlingCriteria(r)) doThis(r)
    else if (successor != null)
      successor.handleRequest(r)

  def doThis(v: T): Unit = ()
  def handlingCriteria(request: T): Boolean = false
}