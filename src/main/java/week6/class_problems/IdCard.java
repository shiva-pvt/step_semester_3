package week6.class_problems;

public class IdCard {
    String studentName;

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public void printName() {
        System.out.println("ID Card Name: " + studentName);
    }

    public static void main(String[] args) {
        IdCard card1 = new IdCard();
        IdCard card2 = new IdCard();

        card1.setName("Kiran");
        card2.setName("Meera");

        card1.printName();
        card2.printName();
    }
}
