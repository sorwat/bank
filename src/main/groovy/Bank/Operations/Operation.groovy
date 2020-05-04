package Bank.Operations

import java.time.LocalTime

abstract class Operation implements ICommand {
    OperationType type
    LocalTime executionDate
    String description

    Operation(OperationType type) {
        this.type = type
        this.executionDate = LocalTime.now()
    }
}