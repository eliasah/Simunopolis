package gui
/**
 * author: Christian Chiev
 */
import scala.swing.Panel
import java.awt.Graphics2D
import java.awt.Color
import scala.Array.canBuildFrom
import scala.swing.event.MouseClicked
import scala.swing.event.MouseDragged
import scala.swing.event.MouseReleased
import java.awt.Dimension
import enumeration.BuildType
import game.Coordinates

class DataPanel(data: Array[Array[Color]], g: GUI) extends Panel {

  listenTo(mouse.clicks, mouse.moves)

  preferredSize_=(new Dimension(500, 500))
  /* var x = 0
  var y = 0
  var xold = 0
  var yold = 0*/
  reactions += {
    case d: MouseDragged => {
      g.command match {
        case BuildType.Road => {
          //  x = d.point.getX().toInt
          //  y = d.point.getY().toInt
        }
        case _ =>
      }
    }
    case e: MouseClicked => {

      g.color = g.command match {
        case BuildType.House => java.awt.Color.blue
        case BuildType.Commerce => java.awt.Color.red
        case BuildType.Industry => java.awt.Color.yellow
        //case e: Empty => java.awt.Color.WHITE
        // case r: Road => java.awt.Color.LIGHT_GRAY
        case _ => java.awt.Color.WHITE
      }
      //verifie si on peut construire la structure 
      val build = g.command match {
        case BuildType.House =>
          g.mayor.reserveZone(BuildType.House,
            new Coordinates((e.point.getX() / 10).toInt, (e.point.getY() / 10).toInt))
        case BuildType.Commerce =>
          g.mayor.reserveZone(BuildType.Commerce,
            new Coordinates((e.point.getX() / 10).toInt, (e.point.getY() / 10).toInt))
        case BuildType.Industry =>
          g.mayor.reserveZone(BuildType.Industry,
            new Coordinates((e.point.getX() / 10).toInt, (e.point.getY() / 10).toInt))
        case _ => false
      }
      //construction du batiment du bouton associe
      if (build) {
        data((e.point.getX() / 10).toInt)((e.point.getY() / 10).toInt) = g.color
        // maj du label du budget
        g.budgetLabel.text_=("    " + g.mayor.budget.getbudget())
      }
      //xold = e.point.getX().toInt
      //yold = e.point.getY().toInt
      repaint
    }
    //Relachement de la souris
    case e: MouseReleased => {
      g.command match {
        case BuildType.Road => {
          /*          println("xold : " + xold)
          println("yold : " + yold)
          println("x : " + x)
          println("y : " + y)*/
        }
        case _ =>
      }
    }
  };

  override def paintComponent(g: Graphics2D) {
    val dx = g.getClipBounds.width.toFloat / data.length
    val dy = g.getClipBounds.height.toFloat / data.map(_.length).max
    for {
      x <- 0 until data.length
      y <- 0 until data(x).length
      x1 = (x * dx).toInt
      y1 = (y * dy).toInt
      x2 = ((x + 1) * dx).toInt
      y2 = ((y + 1) * dy).toInt
    } {
      data(x)(y) match {
        case c: Color => g.setColor(c)
        case _ => g.setColor(Color.WHITE)
      }
      g.fillRect(x1, y1, x2 - x1, y2 - y1)
    }
  }
}