package week8.practice;

import java.util.Scanner;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();
}

class MCQQuestion extends Question {
    public MCQQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    @Override
    public double calculateScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    @Override
    public double calculateScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String studentLower = studentAnswer.toLowerCase();
        
        for (String keyword : keywords) {
            if (studentLower.contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }
        
        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 

        Question[] questions = new Question[n];
        String[] types = new String[n];
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            String text = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];
            int points = Integer.parseInt(parts[6].trim());
            
            types[i] = type;
            if (type.equals("MCQ")) {
                questions[i] = new MCQQuestion(text, correctAnswer, studentAnswer, points);
            } else if (type.equals("TF")) {
                questions[i] = new TFQuestion(text, correctAnswer, studentAnswer, points);
            } else if (type.equals("ESSAY")) {
                questions[i] = new EssayQuestion(text, correctAnswer, studentAnswer, points);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double score = questions[i].calculateScore();
            System.out.printf("%s: %.2f\n", types[i], score);
            total += score;
        }
        System.out.printf("Total Score: %.2f\n", total);
        sc.close();
    }
}
