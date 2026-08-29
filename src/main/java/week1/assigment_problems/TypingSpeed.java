package week1.assigment_problems;

public class TypingSpeed {
    public void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Strings must be of equal length.");
            return;
        }

        int matchedCount = 0;
        int firstMismatchIndex = -1;
        char originalMismatchChar = ' ';
        char typedMismatchChar = ' ';

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCount++;
            } else {
                if (firstMismatchIndex == -1) {
                    firstMismatchIndex = i;
                    originalMismatchChar = original.charAt(i);
                    typedMismatchChar = typed.charAt(i);
                }
            }
        }

        double accuracy = ((double) matchedCount / original.length()) * 100;
        
        if (firstMismatchIndex == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", 
                matchedCount, original.length(), accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n", 
                matchedCount, original.length(), accuracy, firstMismatchIndex, originalMismatchChar, typedMismatchChar);
        }
    }
}
