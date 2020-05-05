package Bank.Operations

import Bank.Products.Account
import Bank.Products.Loan

class CreateLoanOperation extends Operation {
    Account account
    BigDecimal amount

    CreateLoanOperation(Account account, BigDecimal amount) {
        super(OperationType.CREATE_LOAN)
        this.account = account
        this.amount = amount
    }

    @Override
    def execute() {
        Loan loan = new Loan(account: account, balance: amount)
        description = "LOAN CREATED" +
                "\nLOAN_ID: " + String.valueOf(loan.id) +
                "\nAmount:  " + String.valueOf(loan.balance) +
                "\nDate:    " + executionDate.toString()

        // get the money
        account.updateBalance(amount)

        // add to the history
        loan.account.history.add(this)
        loan.owner.products.add(this)
    }
}
