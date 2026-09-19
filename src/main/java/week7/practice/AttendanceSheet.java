package week7.practice;

public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maximumClassSize) {
        presentStudents = new String[maximumClassSize];
        presentCount = 0;
    }

    public void markPresent(String studentName) {
        if (studentName == null || isPresent(studentName)
                || presentCount >= presentStudents.length) {
            return;
        }
        presentStudents[presentCount++] = studentName;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String studentName) {
        if (studentName == null) {
            return false;
        }
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(studentName)) {
                return true;
            }
        }
        return false;
    }
}
