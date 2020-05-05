package Bank.Operations

import Bank.Customer
import Bank.Products.Account

class CreateAccountOperation extends Operation {
    Customer owner

    CreateAccountOperation(Customer owner) {
        super(OperationType.CREATE_ACCOUNT)
        this.owner = owner
    }

    @Override
    def execute() {
        Account account = new Account(owner)
        description = "ACCOUNT CREATED" +
                "\nID:   " + String.valueOf(account.id) +
                "\nDate: " + executionDate.toString()

        account.hitory.add(this)
        account.owner.products.add(account)
    }
}
