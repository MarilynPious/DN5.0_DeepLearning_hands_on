public class Main {

    // Recursive method to calculate future value
    public static double forecast(double currentValue, double growthRate, int years) {

        // Base Case
        if (years == 0) {
            return currentValue;
        }

        // Recursive Call
        return forecast(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {

        double currentValue = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;

        double futureValue = forecast(currentValue, growthRate, years);

        System.out.println("Financial Forecasting");
        System.out.println("----------------------------");
        System.out.println("Current Value : " + currentValue);
        System.out.println("Growth Rate   : 10%");
        System.out.println("Years         : " + years);
        System.out.printf("Future Value  : %.2f%n", futureValue);

        System.out.println("\nAnalysis");
        System.out.println("Time Complexity : O(n)");
        System.out.println("Space Complexity: O(n)");
        System.out.println("Optimization    : Iteration or Dynamic Programming can reduce recursive overhead.");
    }
}