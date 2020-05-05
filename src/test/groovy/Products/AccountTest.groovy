package Products

import Bank.Customer
import Bank.Products.Account
import spock.lang.Specification
import spock.lang.Unroll

class AccountTest extends Specification {

    @Unroll
    def 'test Account should have "customer" as his owner'() {
        when:
        Customer customer = new Customer()
        Account account = new Account(customer)

        then:
        account.owner == customer
    }

    @Unroll
    def 'test Account should have 100 as his balance'() {
        when:
        Customer customer = new Customer()
        Account account = new Account(100, customer)

        then:
        account.balance == 100
    }

    @Unroll
    def 'test updateBalance() should have 100 as his balance'() {
        when:
        Customer customer = new Customer()
        Account account = new Account(customer)
        account.updateBalance(100)

        then:
        account.balance == 100
    }
}