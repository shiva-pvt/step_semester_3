package week9.assignment;

import java.util.Scanner;

abstract class MovieTicket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public MovieTicket(int count) {
        this.count = count;
    }

    protected abstract double getTicketPrice();

    public double calculateAmount() {
        return (getTicketPrice() * count) + (CONVENIENCE_FEE * count);
    }
}

class RegularTicket extends MovieTicket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    protected double getTicketPrice() {
        return 150.0;
    }
}

class PremiumTicket extends MovieTicket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    protected double getTicketPrice() {
        return 250.0;
    }
}

class ReclinerTicket extends MovieTicket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    protected double getTicketPrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        MovieTicket[] tickets = new MovieTicket[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            int count = Integer.parseInt(parts[1]);

            types[i] = type;
            if (type.equals("REGULAR")) {
                tickets[i] = new RegularTicket(count);
            } else if (type.equals("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);
            } else if (type.equals("RECLINER")) {
                tickets[i] = new ReclinerTicket(count);
            }
        }

        double totalCollected = 0;
        for (int i = 0; i < n; i++) {
            double amount = tickets[i].calculateAmount();
            System.out.printf("%s: %.2f\n", types[i], amount);
            totalCollected += amount;
        }
        System.out.printf("Total: %.2f\n", totalCollected);
        sc.close();
    }
}
