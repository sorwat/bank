package Operations

import Bank.Customer
import Bank.Operations.CreateAccountOperation
import Bank.Operations.Operation
import Bank.Operations.OperationType
import spock.lang.Specification
import spock.lang.Unroll

class CreateAccountOperationTest extends Specification {

    @Unroll
    def 'test Operation should have type "OperationType.CREATE_ACCOUNT"'() {
        when:
        Customer customer = new Customer()
        Operation o = new CreateAccountOperation(customer)

        then:
        o.type == OperationType.CREATE_ACCOUNT
    }

    @Unroll
    def 'test Operation should have been added to products history'() {
        when:
        Customer customer = new Customer()
        Operation o = new CreateAccountOperation(customer)
        o.execute()

        then:
        o.account.history.contains(o)
    }

    @Unroll
    def 'test Operation should have add account to customer products'() {
        when:
        Customer customer = new Customer()
        Operation o = new CreateAccountOperation(customer)
        o.execute()

        then:
        customer.products.contains(o.account)
    }
}