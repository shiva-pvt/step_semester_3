package week3.assigment_problems;

public class SumOfNaturalNumbers {
    public void sumOfNaturalNumbers(int n) {
        int i = 1;
        int sum = 0;
        
        while (i <= n) {
            sum += i;
            i++;
        }
        
        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }
}
