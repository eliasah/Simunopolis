package city

import game.Coordinates
import com.sun.org.apache.xpath.internal.operations.Bool

class TableZone(i: Int, j: Int) {
  val data = Array.ofDim[Zone](i, j)

  def add(z: Zone, c: Coordinates): Boolean = {

    if (c.x >= 0 && c.x < i && !(data(c.x)(c.y).isInstanceOf[Zone])) {
      data(c.x)(c.y) = z;
      return true
    }
    printf("Case remplie\n");
    return false
  }
  def del(c: Coordinates): Boolean = {
    if (!data(c.x)(c.y).isInstanceOf[Zone]) {
      data(c.x)(c.y) = null
      return true
    }
    printf("Case vide\n")
    return false;
  }
}