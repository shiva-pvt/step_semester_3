package week1.class_problems;

public class UniqueLetterHunt {
    public void findFirstNonRepeatingChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == c) count++;
            }
            if (count == 1) {
                System.out.println("First Non-Repeating Character: '" + c + "'");
                return;
            }
        }
        System.out.println("No Non-Repeating Character Found");
    }
}
