class AccountCreated extends Operation {
    final String description

    AccountCreated(/* Account account as argument in the future */ id) {
        super(OperationType.CREATION)
        this.description = "ACCOUNT CREATED" +
                "\nID: " + String.valueOf(id) +
                "\nDate: " + executionDate.toString()
    }

    static main(args) {
        Operation creation = new AccountCreated(1)
        println creation.description
    }
}
