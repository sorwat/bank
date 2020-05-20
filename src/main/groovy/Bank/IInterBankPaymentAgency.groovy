package Bank

import Bank.Operations.PaymentOperation

interface IInterBankPaymentAgency {
    void storePayments(List<PaymentOperation> payments)
    List<PaymentOperation> retrievePayments(IBank bank)
}
