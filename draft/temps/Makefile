all: compile

run: compile
	scala Main

compile: Main.class

Main.class: Main.scala Ticker.class
	scalac $<

Ticker.class: Ticker.scala TickerTask.class
	scalac $<

TickerTask.class: TickerTask.scala
	scalac $^

clean:
	@rm -rf *~ *.class
