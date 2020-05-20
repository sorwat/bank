package Bank


import Bank.Operations.PaymentOperation

class InterBankPaymentAgency implements IInterBankPaymentAgency {
    ArrayList<PaymentOperation> payments = new ArrayList<>()

    @Override
    void storePayments(List<PaymentOperation> payments) {
        this.payments.addAll(payments)
    }

    @Override
    List<PaymentOperation> retrievePayments(IBank bank) {
        def payments = getPaymentsByBank(bank)
        this.payments.removeAll(payments)
        return payments
    }

    //TODO implement getting payments by destination bank (SWIFT?)
    List<PaymentOperation> getPaymentsByBank(IBank bank) {
        this.payments.collect()
    }
}
