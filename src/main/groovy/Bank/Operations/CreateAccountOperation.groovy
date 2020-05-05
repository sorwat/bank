package Bank.Operations

import Bank.Products.Account

class CreateAccountOperation extends Operation {
    Account account

    CreateAccountOperation(Account account) {
        super(OperationType.CREATE_ACCOUNT)
        this.account = account
    }

    @Override
    def execute() {
        description = "ACCOUNT CREATED" +
                "\nID:   " + String.valueOf(account.id) +
                "\nDate: " + executionDate.toString()

        account.hitory.add(this)
        account.owner.products.add(account)
    }
}
