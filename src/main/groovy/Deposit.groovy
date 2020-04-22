import static Product.*

class Deposit extends Product{
    def closeDeposit(){
        super.finalize()
    }
}
