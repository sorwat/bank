class OperationCreateAccount extends Operation {
    OperationCreateAccount(/* Account account as argument in the future */ id) {
        super(OperationType.CREATION)

    }

    static main(args) {
        Operation creation = new OperationCreateAccount(1)
        println creation.description
    }

    @Override
    def execute() {
        executionDate = new Date()
        description = "ACCOUNT CREATED" +
                "\nID: " + String.valueOf(id) +
                "\nDate: " + executionDate.toString()
    }
}
