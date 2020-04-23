class ListReportTest extends GroovyTestCase {

    void 'test ListReport should return file filled with filter'(){
        Report report = new ListReport()
        report.filter = ['te','st']
        File file = report.getPdf()
        println file.getText()
        assert file.getText() == "te\r\nst\r\n"
    }
}
