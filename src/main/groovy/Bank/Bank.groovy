package Bank

import Bank.Products.*
import Bank.Operations.*

class Bank {
    ArrayList<Customer> customers
    ArrayList<Operation> history

    Bank() {
        this.customers = new ArrayList<>()
        this.history   = new ArrayList<>()
    }

    ArrayList<Product> getProducts(Customer customer) {
        customer.products
    }

    void createPayment(Account from, Account to, BigDecimal amount) {
        // if there are enough founds. Do we even check this here?
        // Should it rise an exception here if there are not enough founds on the account?
        // Or it will be on the front-end side?
        try {
            executeOperation(new PaymentOperation(from, to, amount))
        } catch(Exception e) {
            println("Exception: ${e}")
        }
    }

    void createWithdrawal(Account account, BigDecimal amount) {
        // if there are enough founds. Same as above in the create Payment?
        // Do we check this here?
        try {
            executeOperation(new WithdrawalOperation(account, amount))
        } catch(Exception e) {
            println("Exception: ${e}")
        }
    }

    void createReport() {}

    void createAccount(Customer owner) {
        executeOperation(new CreateAccountOperation(owner))
    }

    void createLoan(Account account, BigDecimal amount) {
        // Owner will be the same as the owner of the account.
        executeOperation(new CreateLoanOperation(account, amount))
    }

    void createDeposit(Account account, BigDecimal amount) {
        // Owner will be the same as the owner of the account.
        try {
            executeOperation(new CreateDepositOperation(account, amount))
        } catch(Exception e) {
            println("Exception: ${e}")
        }
    }

    void changeInterestRate(Account account, BigDecimal rate) {
        /*
        Bank.InterestRate newInterestRate = new Bank.InterestRate(rate)
        account.setInterestRate(newInterestRate)

        Bank.Operations.Operation op = new ChangeOfInterestRate()
        bankHistory.add(op)
         */
    }

    void executeOperation(Operation operation) {
        // exception can be thrown inside this function
        operation.execute()
        // TODO: it has to check if the operation succeeded before adding to the history
        history.add(operation)
    }

    ArrayList<PaymentOperation> getInterBankPayments() {
        history.collect {it.type == OperationType.PAYMENT} as ArrayList<PaymentOperation>
        //TODO: get only not executed and interbank
    }

    void handleIncomingInterbankPayment(PaymentOperation paymentOperation) {
        //TODO implement
    }
}
