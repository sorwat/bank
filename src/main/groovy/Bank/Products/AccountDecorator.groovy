package Bank.Products

class AccountDecorator {
    private @Delegate
    Account account
    private overdraft_balance
    BigDecimal debit

    void updateDebitCapability(BigDecimal debitCapability) {
        debit -= debitCapability
    }

    def overdraft(BigDecimal amount) {
        if ((debit < 0 && balance == 0.00) || ((balance - amount) < 0 && debit < 0)) {
            overdraft_balance -= amount
        }
    }
}
