package week2.class_problems;

public class FileExtensionValidator {
    public void validateFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            System.out.println("Rejected — invalid file type");
            return;
        }
        
        String extension = filename.substring(lastDotIndex + 1);
        
        if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx") || extension.equalsIgnoreCase("zip")) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected — invalid file type");
        }
    }
}
