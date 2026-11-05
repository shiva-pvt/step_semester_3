package week10.practice;

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line = sc.nextLine();

        String clean = line.replace("[", "").replace("]", "").replace(",", " ").trim();
        if (clean.isEmpty()) return;

        String[] parts = clean.split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
