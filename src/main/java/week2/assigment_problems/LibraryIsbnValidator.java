package week2.assigment_problems;

public class LibraryIsbnValidator {

    public String normalizeCode(String raw) {
        if (raw == null) {
            return null;
        }
        
        String trimmedRaw = raw.trim();
        if (trimmedRaw.length() < 3) {
            return trimmedRaw; 
        }
        
        String publisherCode = trimmedRaw.substring(0, 3).toUpperCase();
        String remainder = trimmedRaw.substring(3);
        
        return publisherCode + remainder;
    }

    public String validateAndFormat(String code) {
        if (code == null) {
            return "Invalid: code cannot be null";
        }
        
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);
        
        StringBuilder formattedRecord = new StringBuilder();
        formattedRecord.append("[").append(pubCode).append("] ")
                       .append("YEAR: ").append(year).append(" | ")
                       .append("CATALOG: ").append(catalog);
                       
        return formattedRecord.toString();
    }
}
