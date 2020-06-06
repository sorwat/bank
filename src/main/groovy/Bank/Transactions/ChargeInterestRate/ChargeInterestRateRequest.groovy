package Bank.Transactions.ChargeInterestRate

import Bank.Products.Account
import Bank.Transactions.TransactionRequest

class ChargeInterestRateRequest extends TransactionRequest {
    BigDecimal amount
    Account account
}
