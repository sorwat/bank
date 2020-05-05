package Bank.Products

import Bank.Customer
import Bank.InterestRate.InterestMechanismInterface

class Loan extends Product {
    Account account

    Loan(def balance = 0.0G, InterestMechanismInterface interestRate = null, Account account) {
        super(balance, interestRate, account.owner)
        this.account = account
    }
}
