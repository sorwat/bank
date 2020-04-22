class Creation extends Operation {
    final String description

    Creation(id) {
        super(OperationType.CREATION)
        this.description = "PRODUCT CREATED" +
                "\nID: " + String.valueOf(id) +
                "\nDate: " + executionDate.toString()
    }

    static main(args) {
        Operation creation = new Creation(1)
        println creation.description
    }
}
