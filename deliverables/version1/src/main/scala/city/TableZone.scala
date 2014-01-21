package city

import game.Coordinates

/**
 * @author Christian Chiev
 *
 */
class TableZone(i: Int, j: Int) {
    val data = Array.ofDim[Zone](i, j)

    /**
     * Ajoute une zone au tableau
     * @param z la zone a ajouter
     * @param c les coordonnees de la zone
     * @return
     */
    def addZone(z: Zone, c: Coordinates): Boolean = {
        if (c.x >= 0 && c.x < i && !(data(c.x)(c.y).isInstanceOf[Zone])) {
            data(c.x)(c.y) = z;
            return true
        }
        return false
    }

    /**
     * Supprime une zone du tableau
     * @param c les coordonnees de la zone
     * @return
     */
    def deleteZone(c: Coordinates): Boolean = {
        if (data(c.x)(c.y).isInstanceOf[Zone]) {
            data(c.x)(c.y) = null
            return true
        }
        return false
    }
}