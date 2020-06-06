package Bank.Transactions.CreateWithdrawal


import Bank.Operations.WithdrawalOperation
import Bank.Transactions.Transaction
import Bank.Transactions.TransactionRequest

class CreateWithdrawal implements Transaction {

    @Override
    boolean createTransaction(TransactionRequest request) {
        if (!(request instanceof CreateWithdrawalRequest)) return false

        new WithdrawalOperation(
                (request as CreateWithdrawalRequest).account,
                (request as CreateWithdrawalRequest).amount)
                .execute()
    }
}
