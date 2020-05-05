package Bank.Products

import Bank.Customer
import Bank.InterestRate.InterestMechanismInterface

class Deposit extends Product {
    Account account

    def closeDeposit() {
        Product.finalize()
    }

    Deposit(def balance, InterestMechanismInterface interestRate = null, Account account) {
        super(balance, interestRate, account.owner)
        this.account = account
    }
}
