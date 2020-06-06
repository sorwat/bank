package Bank.Transactions

import Bank.Transactions.ChargeInterestRate.ChargeInterestRate
import Bank.Transactions.CreatePayment.CreatePayment
import Bank.Transactions.CreateWithdrawal.CreateWithdrawal

class TransactionService {
    List<Transaction> transactionList = [new CreatePayment(), new CreateWithdrawal(), new ChargeInterestRate()]

    void createTransaction(TransactionRequest request) {
        for (transaction in transactionList) {
            if (transaction.createTransaction(request)) return
        }
        throw new Exception("No transaction found!")
    }
}
