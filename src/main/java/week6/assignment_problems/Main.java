package week6.assignment_problems;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Library Inventory Management ===");
        LibraryInventory book1 = new LibraryInventory("Java Programming", "Ali Khan", 12, 450.0);
        LibraryInventory book2 = new LibraryInventory("OOP Concepts", "Sara Ali", 8, 600.0);

        book1.displayBookDetails();
        System.out.println();
        book2.displayBookDetails();

        book1.addStock(5);
        book1.sellBook(3);

        System.out.println();
        System.out.println("Updated Book 1:");
        book1.displayBookDetails();

        System.out.println();
        System.out.println("=== Employee and Company Information Management ===");

        EmployeeCompany emp1 = new EmployeeCompany("Usman", 101, "IT", 50000);
        EmployeeCompany emp2 = new EmployeeCompany("Ayesha", 102, "HR", 45000);

        emp1.displayEmployeeDetails();
        System.out.println();
        emp2.displayEmployeeDetails();

        emp1.giveBonus(3000);

        System.out.println();
        System.out.println("Updated Employee 1:");
        emp1.displayEmployeeDetails();
    }
}
