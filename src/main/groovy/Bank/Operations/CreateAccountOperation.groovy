package Bank.Operations

import Bank.Products.Account

import java.time.LocalTime

class CreateAccountOperation extends Operation {
    int id

    CreateAccountOperation(Account account) {
        super(OperationType.CREATE_ACCOUNT)
        this.id = account.id

        account.hitory.add(this)
        account.owner.products.add(account)
    }

    @Override
    def execute() {
        description = "ACCOUNT CREATED" +
                "\nID:   " + String.valueOf(id) +
                "\nDate: " + executionDate.toString()
    }

}
