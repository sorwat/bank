import spock.lang.Specification
import spock.lang.Unroll

class ListReportTest extends Specification {

    @Unroll
    def 'test ListReport should return file filled with filter #filter'(){
        when:
        Report report = new ListReport()
        report.filter = filter
        File file = report.getPdf()
        println file.getText()

        then:
        file.getText() == "te\r\nst\r\n"

        cleanup:
        file.delete()

        where:
        filter = ['te','st']
    }
}