package gui

/**
 * author: Christian Chiev
 * */
import scala.swing.FlowPanel
import scala.swing.Label

class InformationPanel(g:GUI) extends FlowPanel{
  contents += new Label("Population ")
  contents += g.populationLabel
  contents += new Label("      Budget ")
  contents += g.budgetLabel
  contents += new Label("Année ")
  contents += g.yearLabel
}