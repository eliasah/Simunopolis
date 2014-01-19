package city

trait Population {
  private var population = 0
  private var max = 12
  def setPopulation(people: Int) = population = people 
  def getPopulation:Int = return population
  def setMax(max:Int) =  this.max=max
  def getMax:Int = return max
}