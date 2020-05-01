package InterestRate

class InterestYearlyAward implements InterestMechanismInterface {

    BigDecimal anniversaryRate
    BigDecimal rate

    InterestYearlyAward(BigDecimal inRate, Integer inAnniversary){
        rate = inRate
        anniversaryRate = inAnniversary / 100
    }
    BigDecimal calculateInterest(BigDecimal amount){
        return amount * (rate + anniversaryRate)
    }
}
