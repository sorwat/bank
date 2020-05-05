package Bank.Operations

import Bank.Products.Loan

class CreateLoanOperation extends Operation {
    Loan loan

    CreateLoanOperation(Loan loan) {
        super(OperationType.CREATE_LOAN)
        this.loan = loan
    }

    @Override
    def execute() {
        description = "LOAN CREATED" +
                "\nLOAN_ID: " + String.valueOf(loan.id) +
                "\nAmount:  " + String.valueOf(loan.balance) +
                "\nDate:    " + executionDate.toString()

        loan.account.hitory.add(this)
        loan.account.owner.products.add(loan)
    }
}
