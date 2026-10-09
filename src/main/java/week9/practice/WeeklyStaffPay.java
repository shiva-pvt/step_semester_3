package week9.practice;

import java.util.Scanner;

abstract class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public abstract double calculatePay();
    public String getName() { return name; }
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class Intern extends StaffMember {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        StaffMember[] staff = new StaffMember[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];

            if (type.equals("FULLTIME")) {
                double weeklySalary = Double.parseDouble(parts[2]);
                staff[i] = new FullTimeStaff(name, weeklySalary);
            } else if (type.equals("HOURLY")) {
                double hours = Double.parseDouble(parts[2]);
                double rate = Double.parseDouble(parts[3]);
                staff[i] = new HourlyStaff(name, hours, rate);
            } else if (type.equals("INTERN")) {
                double stipend = Double.parseDouble(parts[2]);
                staff[i] = new Intern(name, stipend);
            }
        }

        double totalPay = 0;
        for (int i = 0; i < n; i++) {
            double pay = staff[i].calculatePay();
            System.out.printf("%s: %.2f\n", staff[i].getName(), pay);
            totalPay += pay;
        }
        System.out.printf("Total Payroll: %.2f\n", totalPay);
        sc.close();
    }
}
