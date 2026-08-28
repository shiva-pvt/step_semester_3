package week2.assigment_problems;

public class WordReversalEncoder {

    public String reverseEachWord(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder reversedSentenceBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            reversedSentenceBuilder.append(wordBuilder.reverse().toString());
            
            if (i < words.length - 1) {
                reversedSentenceBuilder.append(" ");
            }
        }

        return reversedSentenceBuilder.toString();
    }
}
