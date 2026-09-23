package week6.assigment_problems;

public class CompanyEmployee {
    double salary;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displaySalary() {
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        CompanyEmployee emp1 = new CompanyEmployee();
        CompanyEmployee emp2 = new CompanyEmployee();

        emp1.setSalary(45000);
        emp2.setSalary(62000);

        emp1.displaySalary();
        emp2.displaySalary();
    }
}
