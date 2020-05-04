package Bank.Products

import Bank.Customer
import Bank.InterestRate.InterestMechanismInterface

class Deposit extends Product {
    Account account

    def closeDeposit() {
        Product.finalize()
    }

    Deposit(def balance = 0.0G, InterestMechanismInterface interestRate = null, Customer owner = null, Account account) {
        super(balance, interestRate, owner)
        this.account = account
    }
}
