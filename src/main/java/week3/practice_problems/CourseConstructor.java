package week3.practice_problems;

public class CourseConstructor {
    String courseCode;
    String courseName;
    int creditHours;

    public CourseConstructor(String courseCode, String courseName, int creditHours) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public void displayCourse() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credit Hours: " + creditHours);
    }

    public static void main(String[] args) {
        CourseConstructor course = new CourseConstructor("CS101", "Programming", 3);
        course.displayCourse();
    }
}
