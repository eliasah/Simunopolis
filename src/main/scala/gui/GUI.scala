package gui

import scala.swing._
import java.awt.Dimension
import scala.swing.event.MouseClicked
import scala.swing.event.MouseClicked
import scala.swing.event.MouseClicked
import scala.swing.event.MouseDragged
import scala.swing.event.MouseReleased
import player.Player
import game.Coordinates
import enumeration.BuildType

/**
 * author: Christian Chiev
 * */
object City {
  def main(args: Array[String]) {
    println("Simunopolis yeahhhhhhh")
    new GUI(new Player("MyCity")).top
  }
}

class GUI(joueur: Player) extends SimpleSwingApplication {
  //Tableau de case
  val mayor: Player = joueur;
  val data = Array.ofDim[Color](50, 50)

  var command: BuildType.Value = BuildType.Empty
  val budgetLabel: Label = new Label("    20000")
  // variable du point de depart et d'arrive en trainant la souris

  val graph = new DataPanel(data, this)
  val buttons: Buttons = new Buttons(this)
  val information: InformationPanel = new InformationPanel(this)
  // initialisation de la couleur à blanc
  var color = java.awt.Color.WHITE

  def top = new MainFrame {

    title = "Simunopolis";
    preferredSize_=(new Dimension(600, 600))
    // Panel principale
    var fenetrePrincipal = new FlowPanel() {
      contents += information
      contents += graph
      contents += buttons
    }
    contents = fenetrePrincipal
    visible_=(true)
  }
}