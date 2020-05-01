package InterestRate

class InterestLinear implements InterestMechanismInterface {

    BigDecimal rate

    InterestLinear(BigDecimal inRate){
        rate = inRate
    }

    BigDecimal calculateInterest(BigDecimal amount){
        return rate * amount
    }
}
