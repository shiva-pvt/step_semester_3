package week1.class_problems;

public class CustomerNameReverser {
    public String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return new String(reversed);
    }
}
