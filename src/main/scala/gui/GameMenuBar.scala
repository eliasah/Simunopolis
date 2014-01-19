package gui

import scala.swing.MenuBar
import scala.swing.Menu
import scala.swing.RadioMenuItem
import scala.swing.ButtonGroup
import scala.swing.MenuItem
import scala.swing.Action
import scala.swing._
import player._

object GameMenuBar {
    def apply(frame: scala.swing.Frame, mayor: Mayor) = {
        new GameMenuBar(frame, mayor)
    }
}

class GameMenuBar(frame: Frame, mayor: Mayor) extends MenuBar {
    val exitAct = Action("Quitter") {
        mayor.stopTimer
        exit(0)
    }
    val newAct = Action("Nouvelle partie") {
        // TODO
    }
    val chooser = new FileChooser
    val saveAct = Action("Enregistrer la partie") {
        val response = chooser.showSaveDialog(null)
    }
    val openAct = Action("Charger une partie") {
        val response = chooser.showOpenDialog(null)
    }
    val slowAct = Action("Vitesse lente") {
        mayor.slowSpeed
    }
    val normalAct = Action("Vitesse normale") {
        mayor.normalSpeed
    }
    val fastAct = Action("Vitesse rapide") {
        mayor.fastSpeed
    }
    contents += new Menu("Fichier") {
        contents += new MenuItem(newAct)
        contents += new MenuItem(saveAct)
        contents += new Separator
        contents += new MenuItem(exitAct)
    }
    contents += new Menu("Vitesse du jeu") {
        contents += new MenuItem(slowAct)
        contents += new MenuItem(normalAct)
        contents += new MenuItem(fastAct)
    }
    contents += new Menu("Aide") {
        contents += new MenuItem("À propos")
    }
}