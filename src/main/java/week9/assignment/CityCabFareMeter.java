package week9.assignment;

import java.util.Scanner;

abstract class Cab {
    protected double distanceKm;
    protected String time;

    public Cab(double distanceKm, String time) {
        this.distanceKm = distanceKm;
        this.time = time;
    }

    protected abstract double getRatePerKm();
    public abstract boolean offersNightService();

    public double calculateFare() {
        if (time.equals("NIGHT") && !offersNightService()) {
            return -1; // Indicates rejected
        }

        double fare = distanceKm * getRatePerKm();
        fare = Math.max(fare, 100.0); // minimum rule applies first
        
        if (time.equals("NIGHT")) {
            fare *= 1.20; // 20% surcharge
        }

        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double distanceKm, String time) {
        super(distanceKm, time);
    }

    @Override
    protected double getRatePerKm() {
        return 10.0;
    }

    @Override
    public boolean offersNightService() {
        return false;
    }
}

class SedanCab extends Cab {
    public SedanCab(double distanceKm, String time) {
        super(distanceKm, time);
    }

    @Override
    protected double getRatePerKm() {
        return 14.0;
    }

    @Override
    public boolean offersNightService() {
        return true;
    }
}

class SUVCab extends Cab {
    public SUVCab(double distanceKm, String time) {
        super(distanceKm, time);
    }

    @Override
    protected double getRatePerKm() {
        return 18.0;
    }

    @Override
    public boolean offersNightService() {
        return true;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        Cab[] cabs = new Cab[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);
            String time = parts[2];

            types[i] = type;
            if (type.equals("MINI")) {
                cabs[i] = new MiniCab(distance, time);
            } else if (type.equals("SEDAN")) {
                cabs[i] = new SedanCab(distance, time);
            } else if (type.equals("SUV")) {
                cabs[i] = new SUVCab(distance, time);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double fare = cabs[i].calculateFare();
            if (fare == -1) {
                System.out.printf("%s: night service not available\n", types[i]);
            } else {
                System.out.printf("%s: %.2f\n", types[i], fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
