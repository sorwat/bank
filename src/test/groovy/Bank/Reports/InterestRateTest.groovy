package Bank.Reports

import Bank.InterestRate.InterestLinear
import Bank.InterestRate.InterestYearlyAward
import spock.lang.Specification
import spock.lang.Unroll


class InterestRateTest extends Specification {

    @Unroll
    def 'test InterestLinear should return same value #inputRate as passed to constructor'() {
        when:
        def interestRate = new InterestLinear(inputRate)

        then:
        interestRate.rate == inputRate

        where:
        inputRate << [1.0, 0.5, 0.0]
    }

    @Unroll
    def 'test InterestYearlyAward should return same value #inputRate #year as passed to constructor'() {
        when:
        def interestRate = new InterestYearlyAward(inputRate, year)

        then:
        interestRate.rate == inputRate
        interestRate.anniversaryRate == year / 100

        where:
        inputRate << [1.0, 0.5, 0.0]
        year << [0, 1, 5]
    }

    @Unroll
    def 'test InterestLinear calculateInterest should return product of rate and parameter'() {
        when:
        def interestRate = new InterestLinear(rate)

        then:
        interestRate.calculateInterest(input) == result

        where:
        rate = 0.05
        input << [100.0, 0.0]
        result << [5.0, 0.0]
    }

    @Unroll
    def 'test InterestYearlyAward calculateInterest should return product of rate and parameter'() {
        when:
        def interestRate = new InterestYearlyAward(rate, year)

        then:
        interestRate.calculateInterest(input) == result

        where:
        rate = 0.05
        year << [5, 0, 0]
        input << [100.0, 100.0, 0.0]
        result << [10.0, 5.0,0.0]
    }
}
