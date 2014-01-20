package gui

/**
 * author: Christian Chiev
 */
import scala.swing.FlowPanel
import scala.swing.Label

class InformationPanel(g: GUI) extends FlowPanel {
  val populationLabel: Label = new Label("     0")
  val budgetLabel: Label = new Label("    20000")
  // variable du point de depart et d'arrive en trainant la souris
  val yearLabel: Label = new Label("    2014")
  contents += new Label("Population ")
  contents += populationLabel
  contents += new Label("      Budget ")
  contents += budgetLabel
  contents += new Label("Année ")
  contents += yearLabel
}