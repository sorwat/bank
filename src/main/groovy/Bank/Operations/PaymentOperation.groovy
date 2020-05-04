package Bank.Operations

import Bank.Products.Account

import java.time.LocalTime

class PaymentOperation extends Operation {
    Account from
    Account to
    BigDecimal amount

    PaymentOperation(Account from, Account to, BigDecimal amount) {
        super(OperationType.PAYMENT)
        this.from = from
        this.to = to
        this.amount = amount

        from.hitory.add(this)
        to.hitory.add(this)
    }

    @Override
    def execute() {
        description = "PAYMENT" +
                "\nFrom:   " + String.valueOf(from.id) +
                "\nTo:     " + String.valueOf(to.id) +
                "\nAmount: " + String.valueOf(amount) +
                "\nDate:   " + executionDate.toString()
    }
}
