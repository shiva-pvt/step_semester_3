package week3.practice_problems;

public class StudentObjects {
    public static void main(String[] args) {
        StudentRecord s1 = new StudentRecord();
        StudentRecord s2 = new StudentRecord();

        s1.setStudent("Ali", 101, 85.5);
        s2.setStudent("Sara", 102, 90.0);

        System.out.println("Student 1:");
        s1.displayStudent();

        System.out.println("\nStudent 2:");
        s2.displayStudent();

        s1.marks = 95.0;
        System.out.println("\nAfter updating s1:");
        s1.displayStudent();
        s2.displayStudent();
    }
}
