package gui

import swing._

object SwingThing extends SimpleSwingApplication {
  def top = new MainFrame { 
    frame =>
    val sf = new Frame {
      secondFrame =>
      title = "Secondary Frame"
      visible = true
      contents = new FlowPanel {
        contents += new Button(Action("Close Me") { secondFrame.dispose() })
        contents += new Button(Action("Exit") { quit() })
      }
    }
    val recoverBtn = new Button(Action("Recover") { sf.pack(); sf.visible = true })
    val closeBtn = new Button(Action("Close Me") { frame.dispose() })
    val exitBtn = new Button(Action("Exit") { quit() })

    contents = new FlowPanel {
      contents += recoverBtn
      contents += closeBtn
      contents += exitBtn
    }
  }
}