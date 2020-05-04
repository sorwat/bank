package Bank

import Bank.Products.*
import Bank.Operations.*

class Bank {
    BigDecimal nextId = 0
    ArrayList<Product> products = new ArrayList<>()
    ArrayList<Operation> bankHistory = new ArrayList<>()

    Bank() {}

    def ArrayList<Product> getProducts(String iban) {
        ArrayList<Product> userProducts = new ArrayList<>()
        for (product in products) {
            if (product.iban == iban) {
                userProducts.add(product)
            }
        }
        return userProducts
    }

    def void createPayment(Account from, Account to, float amount) {}

    def createReport() {}

    def Account createAccount(String iban) {
        Product newAccount = new Account(++nextId, iban)
        products.add(newAccount)
        executeOperation(new CreateAccount(newAccount.id))

        return newAccount
    }

    def Loan createLoan(Account account, BigDecimal value) {
        Product newLoan = new Loan(++nextId, account, value)
        products.add(newLoan)

        executeOperation(new CreateLoan())
        bankHistory.add(op)

        return newLoan
    }

    def void /* Bank.Products.Deposit in the future? */ createDeposit(Account accont, BigDecimal value, intrestRate) {
        /*
        Bank.Products.Product newDeposit = new Bank.Products.Deposit(++nextId, account, value, interestRate)
        products.add(newDeposit)

        Bank.Operations.Operation op = new DepositCreated()
        bankHistory.add(op)

        return newDeposit
         */
    }

    def void changeInterestRate(Account account, BigDecimal rate) {
        /*
        Bank.InterestRate newInterestRate = new Bank.InterestRate(rate)
        account.setInterestRate(newInterestRate)

        Bank.Operations.Operation op = new ChangeOfInterestRate()
        bankHistory.add(op)
         */
    }

    def void executeOperation(Operation operation) {
        operation.execute()
        bankHistory.add(operation)
    }

    static main(args) {

    }
}
