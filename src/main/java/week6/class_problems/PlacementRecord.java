package week6.class_problems;

public class PlacementRecord {
    String studentName;
    String companyName;

    public void setDetails(String studentName, String companyName) {
        this.studentName = studentName;
        this.companyName = companyName;
    }

    public void displayRecord() {
        System.out.println("Student: " + studentName + " | Company: " + companyName);
    }

    public static void main(String[] args) {
        PlacementRecord record1 = new PlacementRecord();
        PlacementRecord record2 = new PlacementRecord();

        record1.setDetails("Arjun", "TCS");
        record2.setDetails("Bhavya", "Infosys");

        record1.displayRecord();
        record2.displayRecord();
    }
}
