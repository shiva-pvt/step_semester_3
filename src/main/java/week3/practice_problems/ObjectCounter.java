package week3.practice_problems;

public class ObjectCounter {
    static int count = 0;
    String name;

    public ObjectCounter(String name) {
        this.name = name;
        count++;
    }

    public static void displayCount() {
        System.out.println("Total objects created: " + count);
    }

    public static void main(String[] args) {
        ObjectCounter a = new ObjectCounter("A");
        ObjectCounter b = new ObjectCounter("B");
        ObjectCounter c = new ObjectCounter("C");

        System.out.println("Created object: " + a.name);
        System.out.println("Created object: " + b.name);
        System.out.println("Created object: " + c.name);
        displayCount();
    }
}
