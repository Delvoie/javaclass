// Lucas Delvoie
// Program to create a product with requirements and test with input
// November 23rd, 2024

import java.util.InputMismatchException;
import java.util.Scanner;


public class Product {
    // Setup Variables
    private long sku; // SKU must be 8+ digits
    private String name; // Name of the product
    private double unitCost; // Unit cost of the product
    private double salePrice; // Sale price of the product
    private int quantityOnHand; // Quantity in stock
    private int quantityNeeded; // Quantity needed for next order
    private String specialInstructions; // Any special notes

    // Set Defaults
    public Product() {
        sku = 0;
        name = "";
        unitCost = 0.0;
        salePrice = 0.0;
        quantityOnHand = 0;
        quantityNeeded = 0;
        specialInstructions = "";
    }

    // Set Parameters
    public Product(long sku, String name, double unitCost, double salePrice, int quantityOnHand, int quantityNeeded, String specialInstructions) {
        setSku(sku);
        setName(name);
        setUnitCost(unitCost);
        setSalePrice(salePrice);
        setQuantityOnHand(quantityOnHand);
        setQuantityNeeded(quantityNeeded);
        this.specialInstructions = specialInstructions;
    }

    // Get and Set
    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        if (String.valueOf(sku).length() < 8) {
            throw new IllegalArgumentException("SKU must be more than 8 numbers.");
        }
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product must have a name.");
        }
        this.name = name;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        if (unitCost < 0) {
            throw new IllegalArgumentException("Unit cost must be positive.");
        }
        this.unitCost = unitCost;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        if (salePrice < 0) {
            throw new IllegalArgumentException("Price on sale price must be positive.");
        }
        this.salePrice = salePrice;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        if (quantityOnHand < 0) {
            throw new IllegalArgumentException("Quantity in store must be positive.");
        }
        this.quantityOnHand = quantityOnHand;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        if (quantityNeeded < 0) {
            throw new IllegalArgumentException("Quantity needed must be positive.");
        }
        this.quantityNeeded = quantityNeeded;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }
    // W3schools.com. Java Encapsulation. (2024). https://www.w3schools.com/java/java_encapsulation.asp 

    @Override
    public String toString() {
        return "SKU: " + sku + "\n" +
               "Product Name: " + name + "\n" +
               "Unit Cost: $" + unitCost + "\n" +
               "Sale Price: $" + salePrice + "\n" +
               "Quantity on hand: " + quantityOnHand + "\n" +
               "Quantity Needed: " + quantityNeeded + "\n" +
               "Special Instructions: " + specialInstructions;
    }
    
    // Test with input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        try {
            System.out.print("Enter SKU (more than 8 numbers): ");
            long sku = scanner.nextLong();
            product.setSku(sku);

            scanner.nextLine();

            System.out.print("Product Name: ");
            String name = scanner.nextLine();
            product.setName(name);

            System.out.print("Unit Cost: ");
            double unitCost = scanner.nextDouble();
            product.setUnitCost(unitCost);

            System.out.print("Sale Price: ");
            double salePrice = scanner.nextDouble();
            product.setSalePrice(salePrice);

            System.out.print("Quantity on hand: ");
            int quantityOnHand = scanner.nextInt();
            product.setQuantityOnHand(quantityOnHand);

            System.out.print("Quantity Needed: ");
            int quantityNeeded = scanner.nextInt();
            product.setQuantityNeeded(quantityNeeded);

            scanner.nextLine();

            System.out.print("Special Instructions: ");
            String specialInstructions = scanner.nextLine();
            product.specialInstructions = specialInstructions;
            
            System.out.println("\nSuccessfully added product:");
            
            System.out.println("\nProduct Details:");
            System.out.println(product.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Not vaid input. Please enter the correct data type.");
        } finally {
            scanner.close();
        }
    }
}