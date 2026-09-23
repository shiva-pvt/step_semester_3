package week7.practice;

public class Scorecard {
    private final boolean[] results;
    private int recordedAnswers;

    public Scorecard(int questionCount) {
        results = new boolean[questionCount];
        recordedAnswers = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedAnswers < results.length) {
            results[recordedAnswers++] = correct;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedAnswers; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}
