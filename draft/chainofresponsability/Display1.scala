package chainofresponsability

class Display1 extends Handler[Int] {
  def show(v: Int) = println(v)
  override def doThis(v: Int) = show(v)
  override def handlingCriteria(v: Int): Boolean = v < 4
}