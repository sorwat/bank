class OperationWithdrawal extends Operation {
    final String description

    OperationWithdrawal(amount, accountId) {
        super(OperationType.WITHDRAWAL)
        this.description = "WITHDRAWAL" +
                "\nAccount ID: " + String.valueOf(accountId) +
                "\nAmount: " + String.valueOf(amount) +
                "\nDate: " + executionDate.toString()
    }


    static main(args) {
        Operation withdrawal = new OperationWithdrawal(100.0, 1)
        println withdrawal.description
    }

    @Override
    def execute() {
        return null
    }
}
