package Bank.Operations

class Withdrawal extends Operation {

    Withdrawal(amount, accountId) {
        super(OperationType.WITHDRAWAL)
    }


    static main(args) {
        Operation withdrawal = new Withdrawal(100.0, 1)
        println withdrawal.description
    }

    @Override
    def execute() {
        executionDate = new Date()
        description = "WITHDRAWAL" +
                "\nAccount ID: " + String.valueOf(accountId) +
                "\nAmount: " + String.valueOf(amount) +
                "\nDate: " + executionDate.toString()
    }
}
