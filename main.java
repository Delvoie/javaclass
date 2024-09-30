import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    private static final String inputPrompt = "Please enter the diameter of your pizza (6\" to 24\"): ";

    public static void mainPizza(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(inputPrompt);
        float diameter = 0;
        boolean validInput = true;

        while (validInput) {
            try {
                diameter = scanner.nextFloat();
                if (diameter < 6 || diameter > 24) {
                    System.out.println("Error: Pizza must have a diameter in the range of 6\" to 24\" inclusive.");
                    System.out.print(inputPrompt);
                } else {
                    validInput = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a number.");
                System.out.print(inputPrompt);
                scanner.next();
            }
        }

        int targetSlices;
        if (diameter < 8) targetSlices = 4;
        else if (diameter < 12) targetSlices = 6;
        else if (diameter < 14) targetSlices = 8;
        else if (diameter < 16) targetSlices = 10;
        else if (diameter < 20) targetSlices = 12;
        else targetSlices = 16;

        double sliceArea = (Math.PI * diameter * diameter) / (4 * targetSlices);
        System.out.printf("A %.2f\" pizza will yield %d slices.\n", diameter, targetSlices);
        System.out.printf("Each slice will have an area of %.2f square inches.\n", sliceArea);

        scanner.close();
    }
}