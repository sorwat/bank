abstract class Product {
    BigDecimal balance
    InterestRate interestRate
    public String iban
    Customer owner
    Long id
    Date dateOfOpening
    List<Operation> operationList

    // note: adds diff to current balance
    void updateBalance(BigDecimal diff){
        balance += diff
    }
}
