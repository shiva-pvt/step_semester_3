package week9.practice;

import java.util.Scanner;

abstract class TravelMode {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0;

    public TravelMode(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    protected abstract double getBaseFare();

    public double calculateTotalFare() {
        return getBaseFare() + BOOKING_FEE;
    }
}

class BusTravel extends TravelMode {
    public BusTravel(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double getBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainTravel extends TravelMode {
    public TrainTravel(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double getBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightTravel extends TravelMode {
    public FlightTravel(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double getBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        TravelMode[] bookings = new TravelMode[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            types[i] = type;
            if (type.equals("BUS")) {
                bookings[i] = new BusTravel(distance);
            } else if (type.equals("TRAIN")) {
                bookings[i] = new TrainTravel(distance);
            } else if (type.equals("FLIGHT")) {
                bookings[i] = new FlightTravel(distance);
            }
        }

        for (int i = 0; i < n; i++) {
            double fare = bookings[i].calculateTotalFare();
            System.out.printf("%s: %.2f\n", types[i], fare);
        }
        sc.close();
    }
}
