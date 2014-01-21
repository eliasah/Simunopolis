package game

/**
 * @author Isabelle Richard
 *
 */
class Budget(private var budget: Int, private var maxTax: Int, private var moneyTax: Int) {

  /**
   * Verifie que le budget actuel permet de depenser une somme.
   * @param sumOfMoney la somme a payer
   * @return
   */

  private var percent = 100
  def canPay(sumOfMoney: Int): Boolean = {
    return budget >= sumOfMoney
  }
  def pay(less: Int): Unit = {
    budget -= less
  }
  def getbudget(): Int = {
    return budget
  }
  def increaseBudget(sum: Int) = budget += sum

  def increaseTax() = {
    if (percent > maxTax)
      percent = maxTax
    else percent += 10
  }

  def decreaseTax() = {
    if (percent < 0)
      percent = 0
    else percent -= 10
  }
  def getMoneyTax(): Int = return moneyTax
  def getPercent(): Int = return percent
}