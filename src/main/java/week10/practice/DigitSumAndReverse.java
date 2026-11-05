package week10.practice;

import java.util.Scanner;

public class DigitSumAndReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        int sum = 0;
        int rev = 0;
        int temp = n;

        while (temp > 0) {
            int rem = temp % 10;
            sum += rem;
            rev = rev * 10 + rem;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
        sc.close();
    }
}
