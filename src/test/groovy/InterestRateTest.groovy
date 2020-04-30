import spock.lang.Specification
import spock.lang.Unroll

class InterestRateTest extends Specification {

    @Unroll
    def 'test InterestRate should return same value #inputRate as passed to constructor'() {
        when:
        def interestRate = new InterestRate(inputRate)

        then:
        interestRate.any()
        interestRate.rate == inputRate

        where:
        inputRate << [1.0, 10.0, 1000.0]

    }

    @Unroll
    def 'test InterestRate calculateValue should return product of rate and parameter'() {
        when:
        def interestRate = new InterestRate(rate)

        then:
        interestRate.calculateValue(input) == result

        where:
        rate = 2.0
        input << [2.0, 0.0]
        result << [4.0, 0.0]
    }

}