package Bank.Transactions.CreateWithdrawal

import Bank.Products.Account
import Bank.Transactions.TransactionRequest

class CreateWithdrawalRequest extends TransactionRequest {
    BigDecimal amount
    Account account
}
