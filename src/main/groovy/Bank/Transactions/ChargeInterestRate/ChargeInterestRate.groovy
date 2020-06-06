package Bank.Transactions.ChargeInterestRate

import Bank.Operations.ChargeInterestRateOperation
import Bank.Transactions.Transaction
import Bank.Transactions.TransactionRequest

class ChargeInterestRate implements Transaction {

    @Override
    boolean createTransaction(TransactionRequest request) {
        if (!(request instanceof ChargeInterestRateRequest)) return false


        new ChargeInterestRateOperation(
                (request as ChargeInterestRateRequest).account,
                (request as ChargeInterestRateRequest).amount)
                .execute()
    }
}
