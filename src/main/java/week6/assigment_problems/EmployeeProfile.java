package week6.assigment_problems;

public class EmployeeProfile {
    String employeeName;
    String designation;

    public void setDetails(String employeeName, String designation) {
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public void printDetails() {
        System.out.println("Employee: " + employeeName + " | Designation: " + designation);
    }

    public static void main(String[] args) {
        EmployeeProfile emp1 = new EmployeeProfile();
        EmployeeProfile emp2 = new EmployeeProfile();

        emp1.setDetails("Rahul", "Software Engineer");
        emp2.setDetails("Sneha", "Data Analyst");

        emp1.printDetails();
        emp2.printDetails();
    }
}
