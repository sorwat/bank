class InterestRateTest extends GroovyTestCase {

    void 'test InterestRate should return same value as passed to constructor'() {
        def interestRate = new InterestRate(2.0)
        assert interestRate.rate == 2.0
    }

    void 'test InterestRate calculateValue should return product of rate and parameter'(){
        def interestRate = new InterestRate(2.0)
        assert interestRate.calculateValue(2.0) == 4.0
        assert interestRate.calculateValue(0.0) == 0.0
    }

}