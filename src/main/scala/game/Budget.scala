package game

class Budget(initialBudget : Int) {

  private var budget: Int = initialBudget

  def canPay(sumOfMoney: Int): Boolean = {
    return budget >= sumOfMoney
  }

}