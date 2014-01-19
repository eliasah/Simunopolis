package gui

/**
 * @author: Christian Chiev
 */

import scala.swing.FlowPanel
import scala.swing.Button
import scala.swing.Action
import enumeration.BuildType

// tous les boutons de l'interface + les actions associées
class Buttons(g: GUI) extends FlowPanel {
    /*Ajout des boutons pour le construction des batiments et routes*/
    contents += new Button(Action("Maison") {
        g.command = BuildType.House;
    });
    contents += new Button(Action("Commerce") {
        g.command = BuildType.Commerce;
    });
    contents += new Button(Action("Industrie") {
        g.command = BuildType.Industry;
    });
    contents += new Button(Action("Caserne de police") {
        g.command = BuildType.Commerce;
    });
    contents += new Button(Action("Centrale nucléaire") {
        g.command = BuildType.Industry;
    });
    contents += new Button(Action("Route") {
        g.command = BuildType.Road;
    });
    contents += new Button(Action("Destroy") {
        g.command = BuildType.Destroy;
    });
}