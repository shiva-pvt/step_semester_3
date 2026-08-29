package week2.class_problems;

public class MaskedPhoneFormatter {
    public void maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            System.out.println("Invalid phone number");
            return;
        }
        
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                System.out.println("Invalid phone number");
                return;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phone.substring(6));
        sb.insert(6, "-");
        
        System.out.println(sb.toString());
    }
}
