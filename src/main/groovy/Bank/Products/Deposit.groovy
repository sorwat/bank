package Bank.Products

import Bank.InterestRate.InterestMechanismInterface

class Deposit extends Product {
    def closeDeposit() {
        Product.finalize()
    }

    Deposit(def balance = 0.0G, InterestMechanismInterface interestRate, def owner) {
        super(balance, interestRate, owner)
    }
}
