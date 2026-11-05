package week10.practice;

import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double getAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    String getGrade() {
        double avg = getAverage();
        if (avg >= 75) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    void display() {
        System.out.printf("%s: Average %.1f, Grade %s\n", name.toUpperCase(), getAverage(), getGrade());
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            if (line.contains("[") && line.contains("]")) {
                String name = line.substring(0, line.indexOf('[')).trim();
                String marksStr = line.substring(line.indexOf('[') + 1, line.indexOf(']')).trim();
                String[] parts = marksStr.split(",");
                int[] marks = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    marks[i] = Integer.parseInt(parts[i].trim());
                }
                Student student = new Student(name, marks);
                student.display();
            }
        }
        sc.close();
    }
}
