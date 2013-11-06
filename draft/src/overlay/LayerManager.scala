package overlay
import model._

class LayerManager(l: Layers) {

  def applychanges(z:Zone,x:Int,y:Int): Unit = {
    l.connlay.addZone(z)
    l.eleclay.addZone(z)
    l.pollay.addZone(z)
    l.waterlay.addZone(z)
  }

}