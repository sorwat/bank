package Bank

import Bank.Products.*
import Bank.Operations.*

class Bank {
    ArrayList<Product> products
    ArrayList<Customer> customers
    ArrayList<Operation> history

    Bank() {
        this.products  = new ArrayList<>()
        this.customers = new ArrayList<>()
        this.history   = new ArrayList<>()
    }

    ArrayList<Product> getProducts(Customer customer) {
        customer.products
    }

    void createPayment(Account from, Account to, float amount) {}
    void createReport() {}

    Account createAccount(Customer owner) {
        Product newAccount = new Account(owner: owner)
        executeOperation(new CreateAccountOperation(newAccount))

        products.add(newAccount)
        return newAccount
    }

    Loan createLoan(Account account, BigDecimal value) {
        // Owner will be the same as the owner of the account, right?
        Product newLoan = new Loan(account: account, balance: value, owner: account.owner)
        executeOperation(new CreateLoanOperation(newLoan))

        products.add(newLoan)
        return newLoan
    }

    Deposit createDeposit(Account account, BigDecimal value) {
        // Owner will be the same as the owner of the account, right?
        Product newDeposit = new Deposit(account: account, balance: value, owner: account.owner)
        executeOperation(new CreateDepositOperation(newDeposit))

        products.add(newDeposit)
        return newDeposit
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
        history.add(operation)
        operation.execute()
    }

    static main(args) {

    }
}
