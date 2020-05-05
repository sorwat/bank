package Bank.Operations

import Bank.Products.Deposit

class CreateDepositOperation extends Operation {
    Deposit deposit

    CreateDepositOperation(Deposit deposit) {
        super(OperationType.CREATE_DEPOSIT)
        this.deposit = deposit
    }

    @Override
    def execute() {
        description = "DEPOSIT CREATED" +
                "\nDEPOSIT_ID: " + String.valueOf(deposit.id) +
                "\nAmount:     " + String.valueOf(deposit.balance) +
                "\nDate:       " + executionDate.toString()

        deposit.account.hitory.add(this)
        deposit.account.owner.products.add(deposit)
    }
}
