package game

class Budget(initialBudget : Int) {

  private var budget: Int = initialBudget

  def canPay(sumOfMoney: Int): Boolean = {
    println("canPay"+ budget)
    return budget >= sumOfMoney
  }
  def pay(less:Int){
    budget -=less
    println("Pay"+ budget)
  }
  def getbudget():Int ={
    return budget
  }
}