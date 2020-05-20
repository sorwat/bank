package Bank.Products

class AccountDecorator {
    private @Delegate
    Account account
    private overdraft_balance
    BigDecimal debit_

    void updateDebitCapability(BigDecimal debitCapability) {
        debit_ -= debitCapability
    }

    def overdraft(BigDecimal amount) {
        if ((debit_ < 0 && balance == 0.00) || ((balance - amount) < 0 && debit_ < 0)) {
            overdraft_balance -= amount
        }
    }

    AccountDecorator(def account, debit_, overdraft_balnce){
        //super(account)
        this.account = account
        this.debit_ = debit_
        this.overdraft_balance = overdraft_balnce
    }
}
