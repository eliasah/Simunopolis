package gui

import scala.swing._
import java.awt.Dimension
import java.lang.reflect.Field

object test extends SimpleSwingApplication {
  val data = Array.ofDim[Color](50, 50)
  def top = new MainFrame {
    title = "Simunopolis";
    preferredSize_=(new Dimension(500, 500));
    var population: Int = 0;
    var budget: Int = 50000;
    for (i: Int <- 0 to 49) {
      for (j: Int <- 0 to 49) {
        if ((i + j) % 2 == 0)
          data(i)(j) = java.awt.Color.magenta
        else
          data(i)(j) = java.awt.Color.white;
      }
    }
    var a = new FlowPanel() {
      var a = new FlowPanel() {
        contents += new Label("Population ")
        contents += new Label("    " + String.valueOf(population))
        contents += new Label("      Budget ")
        contents += new Label("   " + String.valueOf(budget))
      }
      contents += a;
      var graph = new DataPanel(data) {
        preferredSize_=(new Dimension(450, 400))
      };
      contents +=graph;
      /*graph = new Action("Action Panel"){}
			contents += graph*/
    }
    //a.background = java.awt.Color.white;
    contents = a
  }
}