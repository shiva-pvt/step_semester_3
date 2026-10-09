package week9.assignment;

import java.util.Scanner;

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateTuition();
    public abstract boolean usesBus();

    public double calculateTotalFee() {
        double fee = calculateTuition();
        if (usesBus()) {
            fee += 12000.0;
        }
        return fee;
    }
    
    public String getName() {
        return name;
    }
}

class DayScholar extends Student {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }

    @Override
    public boolean usesBus() {
        return false;
    }
}

class ScholarshipStudent extends Student {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else if (type.equals("SCHOLAR")) {
                students[i] = new ScholarshipStudent(name);
            }
        }

        double totalCollected = 0;
        for (int i = 0; i < n; i++) {
            double fee = students[i].calculateTotalFee();
            System.out.printf("%s: %.2f\n", students[i].getName(), fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        sc.close();
    }
}
