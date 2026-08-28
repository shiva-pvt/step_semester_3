package week3.assigment_problems;

public class VotingEligibility {
    public void checkVotingEligibility(int age) {
        boolean isEligible = age >= 18;
        if (isEligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }
}
