class Withdrawal extends Operation {
    final String description

    Withdrawal(amount, accountId) {
        super(OperationType.WITHDRAWAL)
        this.description = "WITHDRAWAL" +
                "\nAccount ID: " + String.valueOf(accountId) +
                "\nAmount: " + String.valueOf(amount) +
                "\nDate: " + executionDate.toString()
    }

    static main(args) {
        Operation withdrawal = new Withdrawal(100.0, 1)
        println withdrawal.description
    }
}
