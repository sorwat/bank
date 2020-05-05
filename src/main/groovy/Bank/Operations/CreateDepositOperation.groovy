package Bank.Operations

import Bank.Products.Account
import Bank.Products.Deposit

class CreateDepositOperation extends Operation {
    Account account
    BigDecimal amount

    CreateDepositOperation(Account account, BigDecimal amount) {
        super(OperationType.CREATE_DEPOSIT)
        this.account = account
        this.amount = amount
    }

    @Override
    def execute() {
        if (account.balance + account.debit < amount) {
            throw new Exception("Not enough money!")
        } else {
            Deposit deposit = new Deposit(owner: account.owner, account: account, balance: amount)
            description = "DEPOSIT CREATED" +
                    "\nDEPOSIT_ID: " + String.valueOf(deposit.id) +
                    "\nAmount:     " + String.valueOf(deposit.balance) +
                    "\nDate:       " + executionDate.toString()

            // give the money
            account.updateBalance(-amount)

            // add to the history
            deposit.account.hitory.add(this)
            deposit.owner.products.add(this)
        }
    }
}
