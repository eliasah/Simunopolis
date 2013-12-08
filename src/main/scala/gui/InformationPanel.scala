package gui

/**
 * author: Christian Chiev
 * */
import scala.swing.FlowPanel
import scala.swing.Label

class InformationPanel(g:GUI) extends FlowPanel{
  contents += new Label("Population ")
  contents += new Label("    0")
  contents += new Label("      Budget ")
  contents += g.budgetLabel
}