package Products

import Bank.Customer
import Bank.Products.Account
import Bank.Products.AccountDecorator
import spock.lang.Specification
import spock.lang.Unroll

class AccountDecoratorTest extends Specification{
    @Unroll
    def 'test Account Decorator should update debit Capability'() {
        when:
        Customer customer = new Customer()
        Account account = new Account(0, customer)
        AccountDecorator accountDecorator = new AccountDecorator(account: account)
        accountDecorator.updateDebitCapability(111);

        then:
        accountDecorator.debit_ == -111.00
    }
}