/**
 * Program to Find Average Highest and Lowest Temperatures
 * Lucas Delvoie
 * October 6th,2024
 */

 import java.util.Scanner;

 public class TemperatureAnalysis {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         // Get the number of days to determine
         int numDays = getValidDays(scanner);
 
         // Create arrays to store temperature
         double[] lowTemps = new double[numDays];
         double[] highTemps = new double[numDays];
 
         // Get temperature numbers for each day
         for (int i = 0; i < numDays; i++) {
             System.out.println("Enter temperature data for day " + (i + 1));
             lowTemps[i] = getValidTemp(scanner, "Enter low temperature: ");
             highTemps[i] = getValidTemp(scanner, "Enter high temperature: ");
             while (highTemps[i] < lowTemps[i]) {
                 System.out.println("Error: High temperature cannot be lower than low temperature.");
                 highTemps[i] = getValidTemp(scanner, "Enter high temperature: ");
             }
         }
 
         // find average temperatures
         double[] avgTemps = calculateAvgTemps(lowTemps, highTemps);
         System.out.println("Average temperatures:");
         for (int i = 0; i < numDays; i++) {
             System.out.println("Day " + (i + 1) + ": " + avgTemps[i]);
         }
 
         // Find overall average
         double overallAvg = calculateOverallAvg(avgTemps);
         System.out.println("Overall average: " + overallAvg);
 
         // Find and display day with highest temperature
         int highestDay = findHighestDay(highTemps);
         System.out.println("Day with highest temperature: " + (highestDay + 1));
 
         // Find and display day with lowest temperature
         int lowestDay = findLowestDay(lowTemps);
         System.out.println("Day with lowest temperature: " + (lowestDay + 1));
     }
 
      // Get number of days to calculate data for from the user.
     private static int getValidDays(Scanner scanner) {
         int numDays;
         while (true) {
             System.out.print("Enter the number of days to analyze data for (2-366): ");
             numDays = scanner.nextInt();
             if (numDays >= 2 && numDays <= 366) {
                 break;
             }
             System.out.println("Error: Number of days must be between 2 and 366.");
         }
         return numDays;
     }
 
      // Valid temperature.
     private static double getValidTemp(Scanner scanner, String prompt) {
         double temp;
         while (true) {
             System.out.print(prompt);
             temp = scanner.nextDouble();
             if (temp >= -100 && temp <= 100) {
                 break;
             }
             System.out.println("Error: Temperature must be between -100 and 100.");
         }
         return temp;
     }
 
      // Calculates the average temperature for each day.
     private static double[] calculateAvgTemps(double[] lowTemps, double[] highTemps) {
         double[] avgTemps = new double[lowTemps.length];
         for (int i = 0; i < lowTemps.length; i++) {
             avgTemps[i] = (lowTemps[i] + highTemps[i]) / 2;
         }
         return avgTemps;
     }
 
      // Calculates the overall average temperature.
     private static double calculateOverallAvg(double[] avgTemps) {
         double sum = 0;
         for (double temp : avgTemps) {
             sum += temp;
         }
         return sum / avgTemps.length;
     }
 
      // Finds the day with the highest temperature.
     private static int findHighestDay(double[] highTemps) {
         int highestDay = 0;
         double highestTemp = highTemps[0];
         for (int i = 1; i < highTemps.length; i++) {
             if (highTemps[i] > highestTemp) {
                 highestDay = i;
                 highestTemp = highTemps[i];
             }
         }
         return highestDay;
     }
 

      // Finds the day with the lowest temperature.
     private static int findLowestDay(double[] lowTemps) {
         int lowestDay = 0;
         double lowestTemp = lowTemps[0];
         for (int i = 1; i < lowTemps.length; i++) {
             if (lowTemps[i] < lowestTemp) {
                 lowestDay = i;
                 lowestTemp = lowTemps[i];
             }
         }
         return lowestDay;
     }
 }