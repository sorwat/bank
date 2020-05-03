package Operations

class CreateAccount extends Operation {

    CreateAccount(acount) {}

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
                "\nID: " + String.valueOf(id) +
                "\nDate: " + executionDate.toString()

    }


}
