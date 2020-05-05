import Bank.Customer
import Bank.Products.Account
import Bank.Products.Deposit
import spock.lang.Specification
import spock.lang.Unroll

class DepositTest extends Specification {

    @Unroll
    def 'test Deposit should have the same owner as provided Account'() {
        when:
        Customer customer = new Customer()
        Account account = new Account(customer)
        Deposit deposit = new Deposit(amount, account)

        then:
        account.owner == deposit.owner

        where:
        amount = 100
    }
}