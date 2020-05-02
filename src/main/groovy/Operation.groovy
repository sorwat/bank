abstract class Operation {
    final OperationType type
    final Date executionDate
    String description

    Operation(OperationType type) {
        this.type = type
    }

    def abstract execute()

}