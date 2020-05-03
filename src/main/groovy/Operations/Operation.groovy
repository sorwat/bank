package Operations

abstract class Operation implements Command {
    OperationType type
    Date executionDate
    String description
}