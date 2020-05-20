package Bank

import Bank.Customer
import spock.lang.Specification
import spock.lang.Unroll

class CustomerTest extends Specification {

    @Unroll
    def 'test Customer should return a client with the name "Paul"'() {
        when:
        Customer customer = new Customer(name)

        then:
        customer.name == name

        where:
        name = 'Paul'
    }
}
