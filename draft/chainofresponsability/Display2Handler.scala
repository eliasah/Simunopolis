package chainofresponsability

// another solution , pattern specific code is kept in separate trait
trait Display2Handler extends Display2 with Handler[Int] {
  override def doThis(v: Int) = show(v)
  override def handlingCriteria(v: Int): Boolean = v >= 4
}
