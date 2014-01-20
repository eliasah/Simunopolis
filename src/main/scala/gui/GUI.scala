package gui

import java.awt.Dimension
import javax.swing.WindowConstants
import scala.swing._
import scala.swing.event.MouseClicked
import scala.swing.event.MouseDragged
import scala.swing.event.MouseReleased

import city.Zone
import enumeration._
import game._
import player._
import simulationMotor._
import time._

/**
 * @author: Christian Chiev
 */
object City {
  def main(args: Array[String]) {
    new GUI("MyCity").top
  }
}

class GUI(nom: String) extends SimpleSwingApplication with time.Observer {
  val time: Time = new Time()
  val mayor: Mayor = new Mayor(nom, time)
  val god: God = new God(mayor.city)
  time setGod god
  
  def onNotify(s: Subject) = s match {
    case time: Time =>
      information.yearLabel.text_=("    " + mayor.time.year)
      information.populationLabel.text_=("    " + mayor.city.getPopulation)
      information.budgetLabel.text_=("    "+mayor.city.budget.getbudget)
  }

  //Tableau de case

  val data = Array.ofDim[Color](50, 50)

  /**
   * Enregistrement de la GUI comme observateur du temps du joueur
   */
  time.register(this)

  var command: BuildType.Value = BuildType.Empty


  val graph = new DataPanel(data, this)
  val buttons: Buttons = new Buttons(this)
  val information: InformationPanel = new InformationPanel(this)
  // initialisation de la couleur à blanc
  var color = java.awt.Color.WHITE

  def top = new MainFrame {

    menuBar = GameMenuBar.apply(this, mayor)

    peer.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE)
    override def closeOperation = {
      mayor.stopTimer
      exit(0)
    }

    title = "Simunopolis";
    preferredSize_=(new Dimension(1000, 600))
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