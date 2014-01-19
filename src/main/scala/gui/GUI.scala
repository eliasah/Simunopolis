package gui

import scala.swing._
import java.awt.Dimension
import scala.swing.event.MouseClicked
import scala.swing.event.MouseDragged
import scala.swing.event.MouseReleased
import player.Mayor
import game.Coordinates
import enumeration.BuildType
import javax.swing.WindowConstants
import city.Zone
import time._

/**
 * @author: Christian Chiev
 */
object City {
    def main(args: Array[String]) {
        println("Simunopolis yeahhhhhhh")
        new GUI(new Mayor("MyCity")).top
    }
}

class GUI(player: Mayor) extends SimpleSwingApplication with Observer {

    def onNotify(s: Subject) = s match {
        case time: Time =>
            yearLabel.text_=("    " + mayor.time.year)
    }

    //Tableau de case
    val mayor: Mayor = player
    val data = Array.ofDim[Color](50, 50)

    /**
     * Enregistrement de la GUI comme observateur du temps du joueur
     */
    mayor.time.register(this)

    var command: BuildType.Value = BuildType.Empty
    val budgetLabel: Label = new Label("    20000")
    // variable du point de depart et d'arrive en trainant la souris
    val yearLabel: Label = new Label("    2014")

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