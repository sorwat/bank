package Bank.Operations

import Bank.Products.Account

class PaymentOperation extends Operation {
    Account from
    Account to
    BigDecimal amount

    PaymentOperation(Account from, Account to, BigDecimal amount) {
        super(OperationType.PAYMENT)
        this.from = from
        this.to = to
        this.amount = amount
    }

    @Override
    def execute() {
        if (from.balance + from.debit < amount) {
            throw new Exception("Not enough money!")
        } else {
            description = "PAYMENT" +
                    "\nFrom:   " + String.valueOf(from.id) +
                    "\nTo:     " + String.valueOf(to.id) +
                    "\nAmount: " + String.valueOf(amount) +
                    "\nDate:   " + executionDate.toString()

            from.updateBalance(-amount)
            to.updateBalance(amount)

            from.history.add(this)
            to.history.add(this)
        }
    }
}
