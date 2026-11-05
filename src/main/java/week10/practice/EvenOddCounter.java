package week10.practice;

import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line = sc.nextLine();

        String clean = line.replace("[", "").replace("]", "").replace(",", " ").trim();
        if (clean.isEmpty()) return;

        String[] parts = clean.split("\\s+");
        int even = 0;
        int odd = 0;

        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
