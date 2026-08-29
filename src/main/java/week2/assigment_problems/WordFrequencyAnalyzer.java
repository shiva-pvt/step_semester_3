package week2.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class WordFrequencyAnalyzer {

    public void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No feedback provided.");
            return;
        }
        
        List<String> stopWords = Arrays.asList("the", "was", "and", "a", "is", "of", "in");
        
        String normalizedFeedback = feedback.toLowerCase();
        normalizedFeedback = normalizedFeedback.replace(".", "").replace(",", "");
        
        String[] words = normalizedFeedback.split("\\s+");
        
        Map<String, Integer> wordFrequencies = new HashMap<>();
        
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordFrequencies.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
