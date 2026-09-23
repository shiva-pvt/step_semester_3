package week6.class_problems;

public class Student {
    double cgpa;

    public void updateCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    public void displayCGPA() {
        System.out.println("CGPA: " + cgpa);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        s1.updateCGPA(8.5);
        s2.updateCGPA(9.1);

        s1.displayCGPA();
        s2.displayCGPA();
    }
}
