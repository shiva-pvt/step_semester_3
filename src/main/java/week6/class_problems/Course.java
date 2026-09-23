package week6.class_problems;

public class Course {
    String courseName;
    String instructor;

    public void setDetails(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public void printDetails() {
        System.out.println("Course: " + courseName + " | Instructor: " + instructor);
    }

    public static void main(String[] args) {
        Course c1 = new Course();
        Course c2 = new Course();

        c1.setDetails("Data Structures", "Prof. Sharma");
        c2.setDetails("Algorithms", "Prof. Gupta");

        c1.printDetails();
        c2.printDetails();
    }
}
