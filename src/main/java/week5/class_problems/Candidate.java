package week5.class_problems;

import java.util.Arrays;

public class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    @Override
    public int compareTo(Candidate other) {
        double thisComposite = this.cgpa * 10 + this.codingScore;
        double otherComposite = other.cgpa * 10 + other.codingScore;
        return Double.compare(otherComposite, thisComposite);
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int eligibleCount = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                eligibleCount++;
            }
        }

        Candidate[] shortlisted = new Candidate[eligibleCount];
        int index = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted[index++] = c;
            }
        }

        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            Candidate c = shortlisted[i];
            double composite = c.cgpa * 10 + c.codingScore;
            sb.append(i + 1).append(". ").append(c.name).append(" (").append(composite).append(")");
            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
