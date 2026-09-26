package week8.assignment;

import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }
    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }
    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }
    @Override
    public double calculateFinalAmount() {
        return amount + 10.0; // 10 service charge
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 

        Customer[] customers = new Customer[n];
        String[] types = new String[n];
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            
            types[i] = type;
            if (type.equals("STUDENT")) {
                customers[i] = new Student(amount);
            } else if (type.equals("STAFF")) {
                customers[i] = new Staff(amount);
            } else if (type.equals("GUEST")) {
                customers[i] = new Guest(amount);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double finalAmount = customers[i].calculateFinalAmount();
            System.out.printf("%s: %.2f\n", types[i], finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
