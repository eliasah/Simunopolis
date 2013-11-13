package overlay

import game.Zone
import game.Coordinates

class LayerManager(l: Layers) {

  def applychanges(z:Zone,coor: Coordinates): Unit = {
    l.connlay.addZone(z)
    l.eleclay.addZone(z)
    l.pollay.addZone(z)
    l.waterlay.addZone(z)
  }

}