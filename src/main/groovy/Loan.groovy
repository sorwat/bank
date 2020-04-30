class Loan extends Product {
    Account account

    Loan(def balance = 0.0G, InterestRate interestRate, def owner, Account account) {
        super(balance, interestRate, owner)
        this.account = account
    }
}
