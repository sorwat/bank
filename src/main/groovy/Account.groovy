class Account  extends Product{
    int number
    //BigDecimal debitCapability
    BigDecimal debit

    def takeOutLoan(amount){
        balance += amount
    }

    def repayLoan(amount){
        balance -= amount
    }

    def debit(amount){
        if(amount>balance && (balance-amount)>debit){
            balance -=amount
        }
        else{
            return "An operation cannot be performed for the account ${number}, the max debit is: ${debit}"
        }
    }

    void updateDebitCapability(BigDecimal DebitCapability){
        if(DebitCapability != 0.00){
            debit += DebitCapability
        }
    }
}
