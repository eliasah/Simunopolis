package time

trait Subject {
    private var observers: List[Observer] = Nil
    def register(new_observers: Observer*) =
        observers ++= new_observers
    def notifyObservers =
        observers.foreach(_.onNotify(this))
}

trait Observer {
    def onNotify(s: Subject)
}