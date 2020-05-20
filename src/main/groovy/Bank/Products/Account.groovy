package Bank.Products

import Bank.InterestRate.InterestMechanismInterface

class Account extends Product {
    BigDecimal debit
    List<Loan> loanList = new ArrayList<>()

    Account(def balance = 0, BigDecimal debit = 0, InterestMechanismInterface interestRate = null, def owner) {
        super(balance, interestRate, owner)
        this.debit = debit
    }

    def takeOutLoan(amount, Loan loan) {
        balance += amount
        this.loanList.add(loan)
    }

    def repayLoan(amount) {
        balance -= amount
    }

}
