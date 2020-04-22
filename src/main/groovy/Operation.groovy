abstract class Operation {
    final OperationType type
    final Date executionDate
    String description

    Operation(OperationType type) {
        this.type = type
        this.executionDate = new Date()
    }
}