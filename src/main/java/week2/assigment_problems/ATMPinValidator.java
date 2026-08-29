package week2.assigment_problems;

public class ATMPinValidator {

    public void checkPinLength(String pin) {
        if (pin == null) {
            System.out.println("Invalid PIN — PIN cannot be null.");
            return;
        }
        
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
}
