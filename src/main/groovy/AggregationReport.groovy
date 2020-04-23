class AggregationReport implements Report {

    String attribute

    File getPdf(){
        File file = new File("aggregationReport.txt")
        if (file.exists()) {
            file.delete()
        }
        file << attribute
        return file
    }
}
