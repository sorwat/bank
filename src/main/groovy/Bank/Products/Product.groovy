package Bank.Products

import Bank.Customer
import Bank.Generator
import Bank.InterestRate.InterestMechanismInterface
import Bank.Operations.Operation

import java.time.LocalDate

abstract class Product {
    BigDecimal balance
    InterestMechanismInterface interestRate
    String iban
    Customer owner
    Long id
    LocalDate dateOfOpening
    List<Operation> history

    Product(def balance, def interestRate, def owner) {
        this.balance = balance
        this.interestRate = interestRate
        this.iban = Generator.generateIban()
        this.owner = owner
        this.id = Generator.generateId()
        this.dateOfOpening = LocalDate.now()
        this.history = new ArrayList<>()
    }

    // note: adds diff to current balance
    void updateBalance(BigDecimal diff) {
        balance += diff
    }
}
