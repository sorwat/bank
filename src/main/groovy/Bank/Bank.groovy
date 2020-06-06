package Bank


import Bank.Operations.CreateAccountOperation
import Bank.Operations.CreateDepositOperation
import Bank.Operations.CreateLoanOperation
import Bank.Operations.Operation
import Bank.Products.Account
import Bank.Products.Product
import Bank.Transactions.ChargeInterestRate.ChargeInterestRateRequest
import Bank.Transactions.CreatePayment.CreatePaymentRequest
import Bank.Transactions.CreateWithdrawal.CreateWithdrawalRequest
import Bank.Transactions.TransactionService

class Bank implements IBank {
    private InterBankPaymentAgency paymentAgency
    ArrayList<Customer> customers = new ArrayList<>()
    ArrayList<Operation> history = new ArrayList<>()
    private TransactionService transactionService = new TransactionService()

    Bank(InterBankPaymentAgency paymentAgency) {
        this.paymentAgency = paymentAgency
    }

    ArrayList<Product> getProducts(Customer customer) {
        customer.products
    }

    void createPayment(Account from, Account to, BigDecimal amount) {
        // if there are enough founds. Do we even check this here?
        // Should it rise an exception here if there are not enough founds on the account?
        // Or it will be on the front-end side?
        try {
            transactionService.createTransaction(new CreatePaymentRequest(from: from, to: to, amount: amount))
        } catch (Exception e) {
            println("Exception: ${e}")
        }
    }

    void createWithdrawal(Account account, BigDecimal amount) {
        // if there are enough founds. Same as above in the create Payment?
        // Do we check this here?
        try {
            transactionService.createTransaction(new CreateWithdrawalRequest(account: account, amount: amount))
        } catch (Exception e) {
            println("Exception: ${e}")
        }
    }

    void chargeInterestRate(Account account, BigDecimal amount) {
        try {
            transactionService.createTransaction(new ChargeInterestRateRequest(account: account, amount: amount))
        } catch (Exception e) {
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
        } catch (Exception e) {
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
}
