package week9.assignment;

import java.util.Scanner;

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
    public abstract double calculateInsurance();

    public double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return 0.0;
    }
}

class ExpressParcel extends Parcel {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weightKg) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        Parcel[] parcels = new Parcel[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double value = Double.parseDouble(parts[2]);

            types[i] = type;
            if (type.equals("STANDARD")) {
                parcels[i] = new StandardParcel(weight, value);
            } else if (type.equals("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, value);
            } else if (type.equals("FRAGILE")) {
                parcels[i] = new FragileParcel(weight, value);
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            double charge = parcels[i].calculateCharge();
            double insurance = parcels[i].calculateInsurance();
            double total = parcels[i].calculateTotal();
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", types[i], charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        sc.close();
    }
}
