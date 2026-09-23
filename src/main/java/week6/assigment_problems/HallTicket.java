package week6.assigment_problems;

public class HallTicket {
    String candidateName;

    public void setCandidate(String candidateName) {
        this.candidateName = candidateName;
    }

    public void displayTicket() {
        System.out.println("Hall Ticket Candidate: " + candidateName);
    }

    public static void main(String[] args) {
        HallTicket t1 = new HallTicket();
        HallTicket t2 = new HallTicket();

        t1.setCandidate("Priya");
        t2.setCandidate("Anil");

        t1.displayTicket();
        t2.displayTicket();
    }
}
