package Bank.Operations

import Bank.Customer
import Bank.Products.Account
import Bank.Products.Product
import spock.lang.Specification
import spock.lang.Unroll

class PaymentOperationTest extends Specification {

    @Unroll
    def 'test Operation should have type "OperationType.PAYMENT"'() {
        when:
        Operation o = new PaymentOperation(new Account(new Customer()), new Account(new Customer()), amount)

        then:
        o.type == OperationType.PAYMENT

        where:
        amount = 100.0G
    }

    @Unroll
    def 'test Operation should have been added to products history of the sender and receiver'() {
        when:
        Product from = new Account(100, new Customer("bob"))

        Product to = new Account(0, new Customer("steve"))
        Operation o = new PaymentOperation(from, to, amount)
        o.execute()

        then:
        o.from.history.contains(o)
        o.to.history.contains(o)

        where:
        amount = 100.0G
    }

    @Unroll
    def 'test Operation should have change sender\'s balance to 0 and reciver\'s balance to 100'() {
        when:
        Product from = new Account(100, new Customer("bob"))
        Product to = new Account(0, new Customer("steve"))
        Operation o = new PaymentOperation(from, to, amount)
        o.execute()

        then:
        o.from.balance == 0
        o.to.balance == 100

        where:
        amount = 100.0G
    }
}
