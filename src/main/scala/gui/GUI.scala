package gui

import scala.swing._
import java.awt.Dimension
import scala.swing.event.MouseClicked
import scala.swing.event.MouseClicked
import scala.swing.event.MouseClicked
//import sun.nio.fs.AbstractAclFileAttributeView
import scala.swing.event.MouseDragged
import scala.swing.event.MouseReleased
import player.Player
import game.Coordinates

//
object City {
  def main(args: Array[String]) {
    println("Simunopolis yeahhhhhhh")
    new GUI(new Player("MyCity")).top
  }
}

class GUI(mayor: Player) extends SimpleSwingApplication {
  //Tableau de case
  val data = Array.ofDim[Color](50, 50)
  // A revoir
  //Command de construction/destruction initialise a vide
  private[this] var command: mayor.Command = new mayor.Empty;
  // variable du point de depart et d'arrive en trainant la souris
  var x = 0;
  var y = 0;
  var xold = 0;
  var yold = 0;
  // initialisation de la couleur à blanc
  var color = java.awt.Color.WHITE;

  def top = new MainFrame {
    title = "Simunopolis";
    preferredSize_=(new Dimension(600, 600));
    var budgetLabel: Label = new Label("    20000")
    // Panel principale
    var a = new FlowPanel() {
      var a = new FlowPanel() {
        //label pour l'affichage du nombre de population et de budget
        contents += new Label("Population ")
        contents += new Label("    0")
        contents += new Label("      Budget ")
        contents += budgetLabel
      }
      contents += a;
      //panel contenant le graphique
      var graph = new DataPanel(data) {
        //ajout des listerners sur les mouvements de la souris et du click
        listenTo(this.mouse.clicks);
        listenTo(this.mouse.moves);
        preferredSize_=(new Dimension(500, 500));
        // action souris
        reactions += {
          //
          case d: MouseDragged => {
            command match {
              case r: mayor.Road => {
                x = d.point.getX().toInt
                y = d.point.getY().toInt
              }
              case _ =>
            }
          }
          // click souris
          case e: MouseClicked => {

            color = command match {
              case x: mayor.House => java.awt.Color.blue
              case y: mayor.Commerce => java.awt.Color.red
              case z: mayor.Industry => java.awt.Color.yellow
              //case e: Empty => java.awt.Color.WHITE
              // case r: Road => java.awt.Color.LIGHT_GRAY
              case _ => java.awt.Color.WHITE
            }
            //verifie si on peut construire la structure 
            val build = command match {
              case x: mayor.House =>
                mayor.reserveZone(new mayor.House,
                  new Coordinates((e.point.getX() / 10).toInt, (e.point.getY() / 10).toInt))
              case y: mayor.Commerce =>
                mayor.reserveZone(new mayor.Commerce,
                  new Coordinates((e.point.getX() / 10).toInt, (e.point.getY() / 10).toInt))
              case z: mayor.Industry =>
                mayor.reserveZone(new mayor.Industry,
                  new Coordinates((e.point.getX() / 10).toInt, (e.point.getY() / 10).toInt))
              case _ => false
            }
            //construction du batiment du bouton associe
            if (build) {
              data((e.point.getX() / 10).toInt)((e.point.getY() / 10).toInt) = color;
              // maj du label du budget
              budgetLabel.text_=("    " + mayor.city.budget.getbudget().toString)
            }
            xold = e.point.getX().toInt
            yold = e.point.getY().toInt
            repaint;
          }
          //Relachement de la souris
          case e: MouseReleased => {
            command match {
              case r: mayor.Road => {
                println("xold : " + xold)
                println("yold : " + yold)
                println("x : " + x)
                println("y : " + y)
              }
              case _ =>
            }
          }
        };
      };

      /*Ajout des boutons pour le construction des batiments et routes*/
      contents += graph;
      contents += new Button(Action("Maison") {
        command = new mayor.House;
      });
      contents += new Button(Action("Commerce") {
        command = new mayor.Commerce;
      });
      contents += new Button(Action("Industrie") {
        command = new mayor.Industry;
      });
      contents += new Button(Action("Destroy") {
        command = new mayor.Destroy;
      });
      contents += new Button(Action("Route") {
        command = new mayor.Road;
      });

    }
    contents = a
    visible_=(true)
  }
}