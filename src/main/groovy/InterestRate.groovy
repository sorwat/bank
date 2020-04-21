class InterestRate {

    BigDecimal rate

    InterestRate(BigDecimal inRate){
        rate = inRate
    }

    def getRate(){
        rate
    }

    //note: calculates value of interest rate
    BigDecimal calculateValue(BigDecimal amount){
        rate * amount
    }
}
