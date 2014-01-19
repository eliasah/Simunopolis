package game

class Budget(private var budget : Int) {

    /**
     * Verifie que le budget actuel permet de depenser une somme.
     * @param sumOfMoney la somme a payer
     * @return
     */
    def canPay(sumOfMoney: Int): Boolean = {
        return budget >= sumOfMoney
    }
    def pay(less: Int): Unit = {
        budget -= less
    }
    def getbudget(): Int = {
        return budget
    }
}