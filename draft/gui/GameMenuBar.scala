package gui

import scala.swing.MenuBar
import scala.swing.Menu
import scala.swing.RadioMenuItem
import scala.swing.ButtonGroup
import scala.swing.MenuItem
import scala.swing.Action
import scala.swing._
import game.City

object GameMenuBar {
    def apply(frame: scala.swing.Frame, city: game.City) = {
        new GameMenuBar(frame, city)
    }
}

class GameMenuBar(frame: Frame, city: City) extends MenuBar {
    val exitAct = Action("Exit") { frame.dispose() }
    val newAct = Action("New Game") {
        City.apply("New City")
        println("New City Created")
    }

    val chooser = new FileChooser

    val savAct = Action("Save") {
        val response = chooser.showSaveDialog(null)
    }

    val opnAct = Action("Load Game") {
        val response = chooser.showOpenDialog(null)
    }

    contents += new Menu("File") {
        contents += new MenuItem(newAct)
        contents += new MenuItem(savAct)
        contents += new Separator
        contents += new CheckMenuItem("Check me")
        contents += new CheckMenuItem("Me too!")
        contents += new Separator
        val a = new RadioMenuItem("a")
        val b = new RadioMenuItem("b")
        val c = new RadioMenuItem("c")
        val mutex = new ButtonGroup(a, b, c)
        contents ++= mutex.buttons
        contents += new Separator
        contents += new MenuItem(exitAct)
    }
    contents += new Menu("Help") {
        contents += new MenuItem("About")
    }
}