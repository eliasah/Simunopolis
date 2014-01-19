package city

abstract class SubjectObserver {
  /* O is the type of a concrete Observer. */
  type O <: Observer
  /* S is the type of a concrete Subject. */
  type S <: Subject
  /* The following classes are defined using these types. */
  trait Subject {
    /* The type of this must be S */
    self: S =>
    var observers: List[O] = Nil
    def register(new_observers: O*) =
      observers ++= new_observers
    def notifyObservers =
      observers.foreach(_.onNotify(this))
  }
  trait Observer { def onNotify(s: S) }
}