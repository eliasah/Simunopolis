package city

import game.Coordinates

sealed abstract class Zone {
    var density: Int = 0
    var value: Int = 0
    var crime: Int = 0
    var pollution: Int = 0
    var growth: Int = 0

    def description
    def accept(v: ZoneVisitor): Unit

}

case class ResidentialZone(var d: String) extends Zone {
    def description = println("Residential Zone " + d)
    def accept(v: ZoneVisitor) = description
}

case class CommercialZone(var d: String) extends Zone {
    def description = println("Commercial Zone " + d)
    def accept(v: ZoneVisitor) = description
}

case class IndustrialZone(var d: String) extends Zone {
    def description = println("Industrial Zone " + d)
    def accept(v: ZoneVisitor) = description
}

case class PowerPlant extends Zone {
    def description = println("PowerPlant")
    def accept(v: ZoneVisitor) = description
}

case class PoliceDepartment extends Zone {
    def description = println("Police Departement")
    def accept(v: ZoneVisitor) = description
}

case class Land extends Zone with Subject {
    val table: TableZone = new TableZone(50, 50)
    //var children : List[Zone] = new List[Zone]();
    def description = {
        println("Land description : ")
        //children.foreach(x => x.description)
    }
    def accept(v: ZoneVisitor) = description
    //def addChild(z: Zone) = children.::(z)
    def add(z: Zone, c: Coordinates): Boolean = {
        return table add (z, c)
    }
    def del(c: Coordinates): Boolean = {
        return table del (c)
    }
    def increaseDensity(d: Int) {
        table.data.foreach(line => line.foreach(z => if (z != null) density += d))
        notifyObservers
    }
    def decreaseDensity(d: Int) {
        table.data.foreach(line => line.foreach(z => if (z != null) density -= d))
        notifyObservers
    }
}

