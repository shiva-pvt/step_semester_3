package week10.practice;

import java.util.Scanner;

public class FactorialCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            long fact = 1;

            for (int i = 1; i <= n; i++) {
                fact *= i;
            }

            System.out.println(fact);
        }
        sc.close();
    }
}
