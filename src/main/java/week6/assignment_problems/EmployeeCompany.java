package week6.assignment_problems;

public class EmployeeCompany {
    private String employeeName;
    private int employeeId;
    private String department;
    private double salary;

    public EmployeeCompany(String employeeName, int employeeId, String department, double salary) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }

    public void giveBonus(double bonus) {
        salary += bonus;
        System.out.println("Bonus added successfully.");
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
