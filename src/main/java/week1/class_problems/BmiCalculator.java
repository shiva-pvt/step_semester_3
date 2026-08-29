package week1.class_problems;

public class BmiCalculator {
    public String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }

    public void printWellnessReport(double[] heights, double[] weights) {
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.println("BMI: " + String.format("%.2f", bmi) + " | Status: " + getBmiStatus(bmi));
        }
    }
}
