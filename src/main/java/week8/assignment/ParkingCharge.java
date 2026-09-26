package week8.assignment;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }
    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }
    @Override
    public double calculateCharge() {
        if (hours == 0) return 0;
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }
    @Override
    public double calculateCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 

        Vehicle[] vehicles = new Vehicle[n];
        String[] types = new String[n];
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);
            
            types[i] = type;
            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            } else if (type.equals("TRUCK")) {
                vehicles[i] = new Truck(hours);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double charge = vehicles[i].calculateCharge();
            System.out.printf("%s: %.2f\n", types[i], charge);
            total += charge;
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
