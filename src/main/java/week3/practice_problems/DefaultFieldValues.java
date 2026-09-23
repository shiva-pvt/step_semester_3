package week3.practice_problems;

public class DefaultFieldValues {
    int number;
    double value;
    boolean flag;
    char ch;
    String text;

    public void displayDefaultValues() {
        System.out.println("int default: " + number);
        System.out.println("double default: " + value);
        System.out.println("boolean default: " + flag);
        System.out.println("char default: " + (int) ch);
        System.out.println("String default: " + text);
    }

    public static void main(String[] args) {
        DefaultFieldValues obj = new DefaultFieldValues();
        obj.displayDefaultValues();
    }
}
