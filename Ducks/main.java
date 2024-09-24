package Ducks;
import java.util.Scanner;

public class main {
    double pondSize;
    Scanner scanner = new Scanner(System.in);

    public void getPondType() {
        System.out.println("Choose pond type:");
        System.out.println("1. Rectangular");
        System.out.println("2. Circular");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            getRectangularPond();
        } else if (choice == 2) {
            getCircularPond();
        } else {
            System.out.println("Invalid choice. Defaulting to rectangular pond.");
            getRectangularPond();
        }
    }

    public void getRectangularPond() {
        System.out.println("Please enter pond measurements in meters:");
        System.out.print("Enter pond width: ");
        double pondWidth = scanner.nextDouble();
        
        System.out.print("Enter pond length: ");
        double pondLength = scanner.nextDouble();
        
        pondSize = pondWidth * pondLength;
        
        System.out.println("Pond size is: " + pondSize + " square meters");
    }

    public void getCircularPond() {
        System.out.println("Please enter pond measurement in meters:");
        System.out.print("Enter pond radius: ");
        double radius = scanner.nextDouble();
        
        pondSize = calculateCircleArea(radius);
        
        System.out.println("Pond size is: " + pondSize + " square meters");
    }

    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public void getDuckSizes() {
        System.out.print("Please enter duck width in meters: ");
        double duckWidth = scanner.nextDouble();

        System.out.print("Please enter duck length in meters: ");
        double duckLength = scanner.nextDouble();

        int ducksNeeded = (int) Math.floor(pondSize / (duckLength * duckWidth));

        System.out.printf("The amount of ducks needed: %d%n", ducksNeeded);
    }

    public static void main(String[] args) {
        Main duck = new Main();
        duck.getPondType();
        duck.getDuckSizes();
    }
}