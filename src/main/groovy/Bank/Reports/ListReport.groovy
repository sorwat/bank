package Bank.Reports

class ListReport implements Report {

    String[] filter

    File getPdf(){
        File file = new File("report.txt")
        if (file.exists()){
            file.delete()
        }
        filter.each{
            file << it+"\r\n"
        }
        return  file
    }
}
