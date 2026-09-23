package week7.assignment;

public class TrafficLight {
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public void next() {
        switch (color) {
            case "RED" -> color = "GREEN";
            case "GREEN" -> color = "YELLOW";
            case "YELLOW" -> color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }
}
