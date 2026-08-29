package week1.class_problems;

public class RockPaperScissors {
    public void playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            System.out.println("Draw");
        } else if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                   (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                   (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            System.out.println("Player Wins");
        } else {
            System.out.println("Computer Wins");
        }
    }
}
