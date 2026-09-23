package week3.practice_problems;

public class StudentRecord {
    String name;
    int id;
    double marks;

    public void setStudent(String name, int id, double marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Marks: " + marks);
    }
}
