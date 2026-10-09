package week9.practice;

import java.util.Scanner;

abstract class GardenPlot {
    protected String owner;

    public GardenPlot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();
    public String getOwner() { return owner; }
}

class CirclePlot extends GardenPlot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends GardenPlot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends GardenPlot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        GardenPlot[] plots = new GardenPlot[n];
        String[] shapes = new String[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String shape = parts[0];
            String owner = parts[1];
            shapes[i] = shape;

            if (shape.equals("CIRCLE")) {
                double radius = Double.parseDouble(parts[2]);
                plots[i] = new CirclePlot(owner, radius);
            } else if (shape.equals("RECTANGLE")) {
                double length = Double.parseDouble(parts[2]);
                double width = Double.parseDouble(parts[3]);
                plots[i] = new RectanglePlot(owner, length, width);
            } else if (shape.equals("TRIANGLE")) {
                double base = Double.parseDouble(parts[2]);
                double height = Double.parseDouble(parts[3]);
                plots[i] = new TrianglePlot(owner, base, height);
            }
        }

        double totalArea = 0;
        for (int i = 0; i < n; i++) {
            double area = plots[i].calculateArea();
            System.out.printf("%s (%s): %.2f\n", plots[i].getOwner(), shapes[i], area);
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}
