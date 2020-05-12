package Bank.Products

class AccountDecorator {
    private @Delegate
    Account account
    private overdraft_balance

    def overdraft(debit, BigDecimal amount) {
        if (debit < 0 && balance == 0) {
            overdraft_balance -= amount
        }
    }
}
