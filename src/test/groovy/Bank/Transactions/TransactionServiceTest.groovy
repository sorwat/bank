package Bank.Transactions

import Bank.Customer
import Bank.InterestRate.InterestLinear
import Bank.Products.Account
import Bank.Transactions.ChargeInterestRate.ChargeInterestRateRequest
import Bank.Transactions.CreatePayment.CreatePaymentRequest
import Bank.Transactions.CreateWithdrawal.CreateWithdrawalRequest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class TransactionServiceTest extends Specification {

    @Shared
    TransactionService transactionService = new TransactionService()
    @Shared def accFrom = new Account(200, 0.0, new InterestLinear(0.0001), new Customer('sender'))
    @Shared def accTo = new Account(new Customer('receiver'))
    @Shared static def amount = new BigDecimal(100)


    @Unroll
    def 'test TransactionService should call transaction request #request'() {
        given:
        accFrom.balance = 200

        expect:
        transactionService.createTransaction(request)

        where:
        request << [
                new CreatePaymentRequest(from: accFrom, to: accTo, amount: amount),
                new CreateWithdrawalRequest(account: accFrom, amount: amount),
                new ChargeInterestRateRequest(account: accFrom, amount: amount)
        ]
    }
}
