package Operations

class Payment extends Operation {
    final String description

    Payment(amount, fromId, toId) {
        super(OperationType.PAYMENT)
        this.description = "PAYMENT" +
                "\nFrom: " + String.valueOf(fromId) +
                "\nTo: " + String.valueOf(toId) +
                "\nAmount: " + String.valueOf(amount) +
                "\nDate: " + executionDate.toString()
    }

    static main(args) {
        Operation payment = new Payment(100.0, 1, 2)
        println payment.description
    }

    @Override
    def execute() {
        return null
    }
}
