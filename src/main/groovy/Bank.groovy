import InterestRate.InterestLinear
import InterestRate.InterestMechanismInterface
import InterestRate.InterestYearlyAward

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

    def void createPayment(from, to, amount) {}

    def createReport() {}

    def void /* Account in the future? */ createAccount(String iban) {
        /*
        Product newAccount = new Account(++nextId, iban)
        products.add(newAccount)

        Operation op = new AccountCreated()
        bankHistory.add(op)

        return newAccount
        */
    }

    def void /* Loan in the future? */ createLoan(Account account, BigDecimal value) {
        /*
        Product newLoan = new Loan(++nextId, account, value)
        products.add(newLoan)

        Operation op = new LoanCreated()
        bankHistory.add(op)

        return newLoan
         */
    }

    def void /* Deposit in the future? */ createDeposit(Account accont, BigDecimal value, intrestRate) {
        /*
        Product newDeposit = new Deposit(++nextId, account, value, interestRate)
        products.add(newDeposit)

        Operation op = new DepositCreated()
        bankHistory.add(op)

        return newDeposit
         */
    }

    def void changeInterestRate(Account account, BigDecimal rate) {
        /*
        InterestRate newInterestRate = new InterestRate(rate)
        account.setInterestRate(newInterestRate)

        Operation op = new ChangeOfInterestRate()
        bankHistory.add(op)
         */
    }

    static main(args) {

    }
}
