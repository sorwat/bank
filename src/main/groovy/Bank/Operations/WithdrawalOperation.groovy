package Bank.Operations

import Bank.Products.Account

class WithdrawalOperation extends Operation {
    Account account
    BigDecimal amount

    WithdrawalOperation(Account account, BigDecimal amount) {
        super(OperationType.WITHDRAWAL)
        this.account = account
        this.amount = amount
    }

    @Override
    def execute() {
        if (account.balance + account.debit >= amount) {
            throw new Exception("Not enough money!")
        } else {
            description = "WITHDRAWAL" +
                    "\nAccount ID: " + String.valueOf(account.id) +
                    "\nAmount:     " + String.valueOf(amount) +
                    "\nDate:       " + executionDate.toString()

            account.updateBalance(-amount)

            account.history.add(this)
        }
    }
}
