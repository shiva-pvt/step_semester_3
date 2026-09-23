package week5.class_problems;

public class DuplicateTeam {
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] teamNames1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teamNames1));
        
        String[] teamNames2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teamNames2));
    }
}
