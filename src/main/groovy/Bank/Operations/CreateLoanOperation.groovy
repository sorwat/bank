package Bank.Operations

import Bank.Products.Loan

import java.time.LocalTime

class CreateLoanOperation extends Operation {
    int id
    float amount

    CreateLoanOperation(Loan loan) {
        super(OperationType.CREATE_LOAN)
        this.id = loan.id
        this.amount = loan.balance

        loan.account.hitory.add(this)
        loan.account.owner.products.add(loan)
    }

    @Override
    def execute() {
        description = "LOAN CREATED" +
                "\nLOAN_ID: " + String.valueOf(id) +
                "\nAmount:  " + String.valueOf(amount) +
                "\nDate:    " + executionDate.toString()
    }

}
