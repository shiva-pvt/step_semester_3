package week8.assignment;

import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;
    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 

        Room[] rooms = new Room[n];
        String[] types = new String[n];
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);
            
            types[i] = type;
            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = Integer.parseInt(parts[2]);
                rooms[i] = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                rooms[i] = new ACRoom(units);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double bill = rooms[i].calculateBill();
            System.out.printf("%s: %.2f\n", types[i], bill);
            total += bill;
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
