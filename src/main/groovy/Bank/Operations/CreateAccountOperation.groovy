package Bank.Operations

import Bank.Customer
import Bank.Products.Account

class CreateAccountOperation extends Operation {
    Customer owner
    Account account

    CreateAccountOperation(Customer owner) {
        super(OperationType.CREATE_ACCOUNT)
        this.owner = owner
    }

    @Override
    def execute() {
        account = new Account(owner)
        description = "ACCOUNT CREATED" +
                "\nID:   " + String.valueOf(account.id) +
                "\nDate: " + executionDate.toString()

        account.history.add(this)
        account.owner.products.add(account)
    }
}
