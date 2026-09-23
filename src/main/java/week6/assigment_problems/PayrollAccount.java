package week6.assigment_problems;

public class PayrollAccount {
    double totalSalary;

    public void addBonus(double amount) {
        if (amount > 0) {
            totalSalary += amount;
            System.out.println("Bonus added. Total Salary: " + totalSalary);
        }
    }

    public void deductTax(double amount) {
        if (amount > 0 && totalSalary >= amount) {
            totalSalary -= amount;
            System.out.println("Tax deducted. Total Salary: " + totalSalary);
        } else {
            System.out.println("Insufficient salary for tax deduction.");
        }
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount();
        account.totalSalary = 50000;
        
        account.addBonus(5000);
        account.deductTax(2000);
        account.deductTax(60000);
    }
}
