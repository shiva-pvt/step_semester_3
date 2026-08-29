package week2.class_problems;

public class CsvRecordParser {
    public void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        
        System.out.println("Name: " + fields[0] + " | Roll No: " + fields[1] + " | Dept: " + fields[2]);
    }
}
