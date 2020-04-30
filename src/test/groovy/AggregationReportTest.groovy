import spock.lang.Specification
import spock.lang.Unroll

class AggregationReportTest extends Specification {

    @Unroll
    def 'test AggregationReport should return file filled with attribute #attribute'() {
        when:
        Report report = new AggregationReport()
        report.attribute = attribute
        File file = report.getPdf()

        then:
        file.getText() == attribute

        cleanup:
        file.delete()

        where:
        attribute = 'test'
    }
}
