package Bank.Transactions.CreatePayment

import Bank.Operations.PaymentOperation
import Bank.Transactions.CreatePayment.CreatePaymentRequest
import Bank.Transactions.Transaction
import Bank.Transactions.TransactionRequest

class CreatePayment implements Transaction {

    @Override
    boolean createTransaction(TransactionRequest request) {
        if (!(request instanceof CreatePaymentRequest)) return false

        new PaymentOperation(
                (request as CreatePaymentRequest).from,
                (request as CreatePaymentRequest).to,
                (request as CreatePaymentRequest).amount)
                .execute()

        return true
    }
}
