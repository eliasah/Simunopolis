2013/11/27 :
- Correct and update UML according to the meeting with Daniele Varraca (2013/11/27)
  	  -> Define Route entity and how to create it in ZoneCreator :
	     We should choose between Route being abstract entity which results in a more complex represention of routes in the GUI (Complex IA solution)
	  -> Add missing informations to God
	  -> Remember to add Budget in UML
- Finalize and distribute Sequence diagrams in ./deliverables/architecture and update associated README
  	  -> From draft to png using ArgoUML
- Correct and finalize the Use case diagram : 
  	  -> Add use case and relation case :
	     God must retrieve info about present state
- Redistribute tasks to implement the Game.

2013/12/01 :
- Complete the Diagram Class : missing methods, classes.
- Rewrite the sequence diagram from page 2 of the Diagram Class document.
- Try to implement the Diagram Class :
	  -> Focus on the Clients (Players, Zone Creator and GUI)
	  -> Abstract class Zone (Component), Land (Composite) and LeafZone (ResidentialZone, IndustrialZone, etc.)
	  -> Subject-Observer design pattern considering page 2 from Diagram Class document.
	   