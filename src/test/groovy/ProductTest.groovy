import Bank.Products.Product
import spock.lang.Specification
import spock.lang.Unroll

class ProductTest extends Specification {

    @Unroll
    def 'generateIban'(){
        when:
        String iban = Product.generateIban()

        then:
        iban.any()
        iban.length() == 28
        iban.substring(0,2) == 'PL'
        iban.substring(2).toBigInteger().any()
    }
}
