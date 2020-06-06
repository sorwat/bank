package Bank.Operations

import Bank.Products.Account

class ChargeInterestRateOperation extends Operation {
    Account account
    BigDecimal amount
    BigDecimal charge

    ChargeInterestRateOperation(Account account, BigDecimal amount) {
        super(OperationType.PAYMENT)
        this.account = account
        this.amount = amount
        this.charge = this.account.interestRate.calculateInterest(this.amount)
    }

    @Override
    def execute() {
        if (account.balance < this.charge) {
            throw new Exception("Not enough money!")
        } else {
            description = "CHARGE INTEREST RATE" +
                    "\nAccount:   " + String.valueOf(account.id) +
                    "\nCharge:     " + String.valueOf(charge) +
                    "\nAmount: " + String.valueOf(amount) +
                    "\nDate:   " + executionDate.toString()

            account.updateBalance(-charge)

            account.history.add(this)
        }
    }
}
