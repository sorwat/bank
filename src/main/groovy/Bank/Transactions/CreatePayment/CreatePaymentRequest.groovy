package Bank.Transactions.CreatePayment

import Bank.Products.Account
import Bank.Transactions.TransactionRequest

class CreatePaymentRequest extends TransactionRequest {
    BigDecimal amount
    Account from
    Account to
}
