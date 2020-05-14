package Bank.Products

import Bank.Customer
import spock.lang.Specification
import spock.lang.Unroll

class LoanTest extends Specification {

    @Unroll
    def 'test Loan should have the same owner as provided Account'() {
        when:
        Customer customer = new Customer()
        Account account = new Account(customer)
        Loan loan = new Loan(amount, account)

        then:
        account.owner == loan.owner

        where:
        amount = 100
    }
}
