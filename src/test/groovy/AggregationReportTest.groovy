class AggregationReportTest extends GroovyTestCase {

    void 'test AggregationReport should return file filled with attribute'(){
        Report report = new AggregationReport()
        report.attribute = 'test'
        File file = report.getPdf()
        assert file.getText() == 'test'
    }
}
