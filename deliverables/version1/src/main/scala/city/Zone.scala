package city

import game.Coordinates
import com.sun.java.util.jar.pack.PopulationCoding
import game.Budget
import time.Time

/**
 * @author Elias Abou Haydar
 *
 */
sealed abstract class Zone {
    var density: Int = 0
    var value: Int = 0
    var crime: Int = 0
    var pollution: Int = 0
    var growth: Int = 0

    def description
    def accept(v: ZoneVisitor): Unit
}

case class ResidentialZone(var d: String) extends Zone with Population {
    def description = println("Residential Zone " + d)
    def accept(v: ZoneVisitor) = description
}

case class CommercialZone(var d: String) extends Zone with Population {
    def description = println("Commercial Zone " + d)
    def accept(v: ZoneVisitor) = description
}

case class IndustrialZone(var d: String) extends Zone with Population {
    def description = println("Industrial Zone " + d)
    def accept(v: ZoneVisitor) = description
}

case class PowerPlant extends Zone {
    def description = println("PowerPlant")
    def accept(v: ZoneVisitor) = description
}

case class PoliceDepartment extends Zone with Population {
    setMax(12)
    def description = println("Police Departement")
    def accept(v: ZoneVisitor) = description
}

case class Land extends Zone with Subject with Population {

    /** Positions des zones de la ville */
    val table: TableZone = new TableZone(50, 50)

    /** Nombre d'instances de chaque type de zones dans la ville */
    var commercial = 0
    var industrial = 0
    var police = 0
    var powerPlant = 0
    var totalZone = 0

    /** Temps associe a la ville */
    var time = new Time
    
    setMax(0)
    
    /** Budget associe a la ville */
    val budget: Budget = new Budget(20000, 200, 5)

    def description = {
        println("Land description : ")
    }
    def accept(v: ZoneVisitor) = description

    /**
     * Ajoute une zone a la ville et met a jour la population.
     * @param z la zone a ajouter
     * @param c les coordonnees de la zone a ajouter
     * @return true si la zone a ete ajoutee, false sinon
     */
    def addZone(z: Zone, c: Coordinates): Boolean = {
        var result = table addZone (z, c)
        if (result) {
            z match {
                /* Mise a jour de la population maximum */
                case ResidentialZone(_) => setMax(getMax + z.asInstanceOf[ResidentialZone].getMax)
                case CommercialZone(_) => commercial += 1
                case IndustrialZone(_) => industrial += 1
                case PoliceDepartment() => police += 1
                case PowerPlant() => powerPlant += 1
                case _ =>
            }
            totalZone += 1
            /** Avertir les observateurs que la ville a ete modifiee */
            notifyObservers
        }
        return result
    }
    
    /**
     * Supprime une zone de la ville et met a jour la population.
     * @param c les coordonnees de la zone a supprimer
     * @return
     */
    def deleteZone(c: Coordinates): Boolean = {
        table.data(c.x)(c.y) match {
            case ResidentialZone(_) => setMax(getMax - table.data(c.x)(c.y).asInstanceOf[ResidentialZone].getMax)
            case CommercialZone(_) => commercial -= 1
            case IndustrialZone(_) => industrial -= 1
            case PoliceDepartment() => police -= 1
            case PowerPlant() => powerPlant -= 1
            case _ => ()
        }
        val deleted = table deleteZone (c)
        if (deleted) {
            /** Avertir les observateurs que la ville a ete modifiee */
            notifyObservers
        }
        return deleted
    }
}

