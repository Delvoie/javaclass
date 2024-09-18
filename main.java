import java.util.Scanner;

public class main {

    int pondSize;

    // Get rectangular pond size from user
    public void getRectangularPond() {
        int pondWidth;
        int pondLength;
        System.out.println("Please enter pond measurements in meters:");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter pond width: ");
        pondWidth = scanner.nextInt();
        
        System.out.print("Enter pond length: ");
        pondLength = scanner.nextInt();
        
        pondSize = pondWidth * pondLength;
        
        System.out.println("Pond size is: " + pondSize + " square meters");    }

        // Get rectangular pond size from user
    public void getDuckSizes() {
        int duckWidth;
        int duckLength; 
        System.out.print("Please enter duck width in meters: ");
        Scanner scanner = new Scanner(System.in);
        duckWidth = scanner.nextInt();

        System.out.print("Please enter duck length in meters: ");
        duckLength = scanner.nextInt();

        int ducksNeeded = (int) Math.floor(pondSize / (duckLength * duckWidth));

        System.out.printf("The ammount of ducks needed: %d%n", ducksNeeded); 
       }

    public static void main(String[] args) {
        main duck = new main();
        duck.getRectangularPond();
        duck.getDuckSizes();
    }
}