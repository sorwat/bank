package Bank.Operations

import Bank.Products.Deposit

import java.time.LocalTime

class CreateDepositOperation extends Operation {
    int id
    float amount

    CreateDepositOperation(Deposit deposit) {
        super(OperationType.CREATE_DEPOSIT)
        this.id     = deposit.id
        this.amount = deposit.balance

        deposit.account.hitory.add(this)
        deposit.account.owner.products.add(deposit)
    }

    @Override
    def execute() {
        description = "DEPOSIT CREATED" +
                "\nDEPOSIT_ID: " + String.valueOf(id) +
                "\nAmount:     " + String.valueOf(amount) +
                "\nDate:       " + executionDate.toString()
    }

}
