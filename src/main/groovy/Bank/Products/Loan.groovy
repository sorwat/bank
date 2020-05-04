package Bank.Products

import Bank.Customer
import Bank.InterestRate.InterestMechanismInterface

class Loan extends Product {
    Account account

    Loan(def balance = 0.0G, InterestMechanismInterface interestRate = null, Customer owner = null, Account account) {
        super(balance, interestRate, owner)
        this.account = account
    }
}
