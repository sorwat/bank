import InterestRate.InterestMechanismInterface

class Deposit extends Product {
    def closeDeposit() {
        super.finalize()
    }

    Deposit(def balance = 0.0G, InterestMechanismInterface interestRate, def owner) {
        super(balance, interestRate, owner)
    }
}
