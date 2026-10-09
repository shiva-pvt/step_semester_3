package week9.assignment;

import java.util.Scanner;

abstract class Appliance {
    protected double hours;
    protected boolean saverMode;

    public Appliance(double hours, boolean saverMode) {
        this.hours = hours;
        this.saverMode = saverMode;
    }

    protected abstract double getPowerRating();
    public abstract boolean supportsSaverMode();

    public double calculateUnits() {
        if (saverMode && !supportsSaverMode()) {
            return -1; // Indicates error
        }

        double units = (getPowerRating() * hours) / 1000.0;
        if (saverMode && supportsSaverMode()) {
            units *= 0.75;
        }
        return units;
    }

    public double calculateCost() {
        double units = calculateUnits();
        if (units == -1) return -1;
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    protected double getPowerRating() { return 150.0; }

    @Override
    public boolean supportsSaverMode() { return false; }
}

class AirConditioner extends Appliance {
    public AirConditioner(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    protected double getPowerRating() { return 1500.0; }

    @Override
    public boolean supportsSaverMode() { return true; }
}

class TV extends Appliance {
    public TV(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    protected double getPowerRating() { return 100.0; }

    @Override
    public boolean supportsSaverMode() { return false; }
}

class WashingMachine extends Appliance {
    public WashingMachine(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    protected double getPowerRating() { return 500.0; }

    @Override
    public boolean supportsSaverMode() { return true; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        Appliance[] appliances = new Appliance[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverMode = parts.length == 3 && parts[2].equals("SAVER");

            types[i] = type;
            if (type.equals("FRIDGE")) {
                appliances[i] = new Fridge(hours, saverMode);
            } else if (type.equals("AC")) {
                appliances[i] = new AirConditioner(hours, saverMode);
            } else if (type.equals("TV")) {
                appliances[i] = new TV(hours, saverMode);
            } else if (type.equals("WASHER")) {
                appliances[i] = new WashingMachine(hours, saverMode);
            }
        }

        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            double cost = appliances[i].calculateCost();
            if (cost == -1) {
                System.out.printf("%s: saver mode not supported\n", types[i]);
            } else {
                double units = appliances[i].calculateUnits();
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", types[i], units, cost);
                totalCost += cost;
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}
