package gui

import scala.swing._
import java.awt.Dimension
import java.lang.reflect.Field
import scala.swing.event.MouseClicked
import scala.swing.event.MouseClicked
import scala.swing.event.MouseClicked

object test extends SimpleSwingApplication {
  val data = Array.ofDim[Color](50, 50)
  var batiment = 0;
  def top = new MainFrame {
    title = "Simunopolis";
    preferredSize_=(new Dimension(600, 600));
    var population: Int = 0;
    var budget: Int = 50000;
    /*for (i: Int <- 0 to 49) {
      for (j: Int <- 0 to 49) {
        if ((i + j) % 2 == 0)
          data(i)(j) = java.awt.Color.lightGray
        else
          data(i)(j) = java.awt.Color.white;
      }
    }*/

    var a = new FlowPanel() {
      var a = new FlowPanel() {
        contents += new Label("Population ")
        contents += new Label("    " + String.valueOf(population))
        contents += new Label("      Budget ")
        contents += new Label("   " + String.valueOf(budget))
      }
      contents += a;
      var graph = new DataPanel(data) {
        listenTo(this.mouse.clicks);
        preferredSize_=(new Dimension(500, 500));

        reactions += {
          case e: MouseClicked => {
            println((e.point.getX() / 10).toInt);
            println((e.point.getY() / 10).toInt);
            var color=java.awt.Color.lightGray;
            if(batiment==1){
              color=java.awt.Color.blue;
            }
            data((e.point.getX() / 10).toInt)((e.point.getY() / 10).toInt)=color;
            repaint;
          }
        };
      };
      contents += graph;

      contents += new Button(Action("Maison"){
        batiment=1;
      });
    }
    contents = a
  }
}