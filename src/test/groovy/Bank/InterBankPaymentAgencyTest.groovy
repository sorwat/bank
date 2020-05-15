package Bank

import Bank.Operations.PaymentOperation
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class InterBankPaymentAgencyTest extends Specification {

    @Shared
            agency
    @Shared
            payments = [new PaymentOperation(null, null, null), new PaymentOperation(null, null, null)]

    def setup() {
        agency = new InterBankPaymentAgency()
    }

    @Unroll
    def 'test InterBankPaymentAgency storePayments should collect payments'() {
        setup:
        assert agency.payments.empty

        when:
        agency.storePayments(payments)

        then:
        !agency.payments.empty
    }

    @Unroll
    def 'test InterBankPaymentAgency retrievePayments should return payments'() {
        setup:
        agency.payments.addAll(payments)
        assert !agency.payments.empty
        def bank = Mock(IBank)

        when:
        List<PaymentOperation> result = agency.retrievePayments(bank)

        then:
        result.any()
        !result.empty
    }
}
