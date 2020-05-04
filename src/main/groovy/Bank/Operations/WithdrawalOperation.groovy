package Bank.Operations

import Bank.Products.Account

class WithdrawalOperation extends Operation {
    int id
    BigDecimal amount

    WithdrawalOperation(BigDecimal amount, Account account) {
        super(OperationType.WITHDRAWAL)
        this.amount = amount
        this.id = account.id

        account.hitory.add(this)
    }

    @Override
    def execute() {
        description = "WITHDRAWAL" +
                "\nAccount ID: " + String.valueOf(id) +
                "\nAmount:     " + String.valueOf(amount) +
                "\nDate:       " + executionDate.toString()
    }
}
