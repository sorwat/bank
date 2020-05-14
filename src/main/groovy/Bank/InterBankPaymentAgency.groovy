package Bank


import Bank.Operations.PaymentOperation

class InterBankPaymentAgency {
    ArrayList<Bank> banks = new ArrayList<>()
    ArrayList<PaymentOperation> payments = new ArrayList<>()


    InterBankPaymentAgency() {
    }

    // performed periodically with trigger
    private void performPeriodicalJobs() {
        collectPayments()
        sortPayments() //TODO refactor or get rid of, seems pointless now
        sendPayments()
    }

    private void collectPayments() {
        payments.addAll(
                banks.inject([]) { result, bank ->
                    result.addAll(bank.getInterBankPayments())
                    result
                })
    }

    private void sortPayments() {
        payments.sort { it.executionDate }
    }

    private void sendPayments() {
        payments.forEach { payment -> sendPayment(payment) }
    }

    private void sendPayment(PaymentOperation payment) {
        getBank(payment).handleIncomingInterbankPayment(payment)
        payments.remove(payment)
    }

    //TODO implement: accordint to destination (PaymentOperation.to) return payment destination bank
    private Bank getBank(PaymentOperation paymentOperation) {
        banks.get(0)
    }
}
