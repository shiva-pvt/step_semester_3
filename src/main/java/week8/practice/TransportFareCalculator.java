package week8.practice;

import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }
    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }
    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class Metro extends Transport {
    private double peakHourFactor;
    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 

        Transport[] journeys = new Transport[n];
        String[] types = new String[n];
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);
            
            types[i] = type;
            if (type.equals("BUS")) {
                journeys[i] = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new Train(distance);
            } else if (type.equals("METRO")) {
                double peakHourFactor = Double.parseDouble(parts[2]);
                journeys[i] = new Metro(distance, peakHourFactor);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double fare = journeys[i].calculateFare();
            System.out.printf("%s: %.2f\n", types[i], fare);
            total += fare;
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
