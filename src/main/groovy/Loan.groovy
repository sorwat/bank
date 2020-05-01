import InterestRate.InterestMechanismInterface

class Loan extends Product {
    Account account

    Loan(def balance = 0.0G, InterestMechanismInterface interestRate, def owner, Account account) {
        super(balance, interestRate, owner)
        this.account = account
    }
}
