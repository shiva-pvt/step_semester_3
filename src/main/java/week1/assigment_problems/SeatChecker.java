package week1.assigment_problems;

public class SeatChecker {
    public void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                }
            }
        }
        
        if (duplicateFound == false) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
