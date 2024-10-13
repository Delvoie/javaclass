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
