class Account extends Product {
    BigDecimal debit
    List<Loan> loanList = new ArrayList<>()

    Account(def balance = 0, BigDecimal debit = 0, InterestRate interestRate = null, def owner = null) {
        super(balance, interestRate, owner)
        this.debit = debit
    }

    def takeOutLoan(amount, Loan, loan) {
        balance += amount
        this.loanList.add(loan)
    }

    def repayLoan(amount) {
        balance -= amount
    }

    def debit(amount) {
        if (amount > balance && (balance - amount) > debit) {
            balance -= amount
        } else {
            return "An operation cannot be performed for the account ${id}, the max debit is: ${debit}"
        }
    }

    void updateDebitCapability(BigDecimal debitCapability) {
        debit += debitCapability
    }
}
