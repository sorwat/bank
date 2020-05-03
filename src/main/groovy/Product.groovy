import InterestRate.InterestMechanismInterface
import Operations.Operation

import java.time.LocalDate

abstract class Product {
    BigDecimal balance
    InterestMechanismInterface interestRate
    String iban
    Customer owner
    Long id
    LocalDate dateOfOpening
    List<Operation> operationList = new ArrayList<>()

    Product(def balance, def interestRate, def owner) {
        this.balance = balance
        this.interestRate = interestRate
        this.iban = generateIban()
        this.owner = owner
        this.id = generateId()
        this.dateOfOpening = LocalDate.now()
    }

    // note: adds diff to current balance
    void updateBalance(BigDecimal diff) {
        balance += diff
    }

    static String generateIban() {
        'PL' + new Random().with {
            (1..26).collect { nextInt(10) }.join()
        }
    }

    static long generateId() {
        0 //TODO implement
    }
}
