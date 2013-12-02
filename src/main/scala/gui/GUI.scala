package gui

import scala.swing._
import java.awt.Dimension
import scala.swing.event.MouseClicked
import scala.swing.event.MouseClicked
import scala.swing.event.MouseClicked
import sun.nio.fs.AbstractAclFileAttributeView
import scala.swing.event.MouseDragged
import scala.swing.event.MouseReleased

object GUI extends SimpleSwingApplication {
  /**/
  abstract class Command
  case class Empty extends Command
  case class House extends Command
  case class Commerce extends Command
  case class Industry extends Command
  case class Road extends Command
  case class Destroy extends Command

  val data = Array.ofDim[Color](50, 50)
  var command: Command = new Empty;
  var x = 0;
  var y = 0;
  var xold = 0;
  var yold = 0;
  var color = java.awt.Color.WHITE;
  def top = new MainFrame {
    title = "Simunopolis";
    preferredSize_=(new Dimension(600, 600));
    var population: Int = 0;
    var budget: Int = 50000;
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
        listenTo(this.mouse.moves);
        preferredSize_=(new Dimension(500, 500));

        reactions += {
          case d: MouseDragged => {
            command match {
              case r: Road => {
                x = d.point.getX().toInt
                y = d.point.getY().toInt
              }
              case _ =>
            }
          }
          case e: MouseClicked => {
            /* println((e.point.getX() / 10).toInt);
            println((e.point.getY() / 10).toInt);*/
            color = command match {
              case x: House => java.awt.Color.blue
              case y: Commerce => java.awt.Color.red
              case z: Industry => java.awt.Color.yellow
              case e: Empty => java.awt.Color.WHITE
              case r: Road => java.awt.Color.LIGHT_GRAY
              case _ => java.awt.Color.WHITE
            }
            xold = e.point.getX().toInt
            yold = e.point.getY().toInt
            data((e.point.getX() / 10).toInt)((e.point.getY() / 10).toInt) = color;
            repaint;
          }
          case e: MouseReleased => {
            command match {
              case r: Road => {
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
      contents += graph;
      contents += new Button(Action("Maison") {
        command = new House;
      });
      contents += new Button(Action("Commerce") {
        command = new Commerce;
      });
      contents += new Button(Action("Industrie") {
        command = new Industry;
      });
      contents += new Button(Action("Destroy") {
        command = new Destroy;
      });
      contents += new Button(Action("Route") {
        command = new Road;
      });

    }
    contents = a
  }
}