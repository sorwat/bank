package Bank.Operations

import Bank.InterestRate.InterestYearlyAward

class CreateAccount extends Operation {
    int accountId

    CreateAccount(InterestYearlyAward interestYearlyAward) {
       accountId = account.id
    }

    static main(args) {
        Operation o = new CreateAccount(1)
        o.execute()
        println(o.description)
    }

    @Override
    def execute() {
        type = OperationType.CREATE_ACCOUNT;
        executionDate = new Date()
        description = "ACCOUNT CREATED" +
                "\nID: " + String.valueOf(accountId) +
                "\nDate: " + executionDate.toString()

    }


}
