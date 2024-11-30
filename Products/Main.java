import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        try {
            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1) Create Product");
                System.out.println("2) Create Perishable Product");
                System.out.println("3) Edit Product by SKU");
                System.out.println("4) Delete Product by SKU");
                System.out.println("5) Display Product by SKU");
                System.out.println("6) Display All Products");
                System.out.println("7) Exit");
                System.out.println("Enter The Number : ");

                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    scanner.nextLine(); // Clear invalid input
                    continue;
                }

                switch (choice) {
                    case 1 -> createProduct(false);
                    case 2 -> createProduct(true);
                    case 3 -> editProduct();
                    case 4 -> deleteProduct();
                    case 5 -> displayProduct();
                    case 6 -> displayAllProducts();
                    case 7 -> System.out.println("Exiting program. Goodbye!");
                }
            } while (choice != 7);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Create Product (Regular or Perishable)
    private static void createProduct(boolean isPerishable) {
        System.out.println("\n--- Create Product ---");
        try {
            System.out.print("Enter SKU (8+ digits): ");
            long sku = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Unit Cost: ");
            double unitCost = scanner.nextDouble();
            System.out.print("Enter Sale Price: ");
            double salePrice = scanner.nextDouble();
            System.out.print("Enter Quantity on Hand: ");
            int quantityOnHand = scanner.nextInt();
            System.out.print("Enter Quantity Needed: ");
            int quantityNeeded = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Special Instructions: ");
            String specialInstructions = scanner.nextLine();

            if (isPerishable) {
                System.out.print("Enter expiration date (YYYY-MM-DD): ");
                LocalDate expirationDate = LocalDate.parse(scanner.nextLine());
                products.add(new PerishableProduct(sku, name, unitCost, salePrice, quantityOnHand,
                        quantityNeeded, specialInstructions, expirationDate));
            } else {
                products.add(new Product(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded,
                        specialInstructions));
            }
            System.out.println("Product created successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Edit Product by SKU
    private static void editProduct() {
        System.out.println("\n--- Edit Product ---");
        if (products.isEmpty()) {
            System.out.println("No products avalible.");
            return;
        }

        try {
            System.out.print("Enter SKU of the product to edit: ");
            long sku = scanner.nextLong();
            scanner.nextLine(); // Clear buffer

            Product productToEdit = findProductBySKU(sku);
            if (productToEdit == null) {
                System.out.println("Product not found.");
                return;
            }

            System.out.print("Enter new name: ");
            productToEdit.setName(scanner.nextLine());

            System.out.print("Enter new unit cost: ");
            productToEdit.setUnitCost(scanner.nextDouble());

            System.out.print("Enter new sale price: ");
            productToEdit.setSalePrice(scanner.nextDouble());

            System.out.print("Enter new quantity on hand: ");
            productToEdit.setQuantityOnHand(scanner.nextInt());

            System.out.print("Enter new quantity needed: ");
            productToEdit.setQuantityNeeded(scanner.nextInt());
            scanner.nextLine(); // Clear buffer

            System.out.println("Product edited successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred while editing the product: " + e.getMessage());
        }
    }

    // Delete Product by SKU
    private static void deleteProduct() {
        System.out.println("\n--- Delete Product ---");
        if (products.isEmpty()) {
            System.out.println("No products avalible.");
            return;
        }

        try {
            System.out.print("Enter SKU of the product to delete: ");
            long sku = scanner.nextLong();
            scanner.nextLine(); // Clear buffer

            Product productToDelete = findProductBySKU(sku);
            if (productToDelete == null) {
                System.out.println("Product not found.");
                return;
            }

            products.remove(productToDelete);
            System.out.println("Product deleted successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the product: " + e.getMessage());
        }
    }

    // Display Product by SKU
    private static void displayProduct() {
        System.out.println("\n--- Display Product ---");
        if (products.isEmpty()) {
            System.out.println("No products avalible.");
            return;
        }

        try {
            System.out.print("Enter SKU of the product to display: ");
            long sku = scanner.nextLong();
            scanner.nextLine(); // Clear buffer

            Product productToDisplay = findProductBySKU(sku);
            if (productToDisplay == null) {
                System.out.println("Product not found.");
                return;
            }

            System.out.println(productToDisplay);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred while displaying the product: " + e.getMessage());
        }
    }

    // Find Product by SKU
    private static Product findProductBySKU(long sku) {
        for (Product product : products) {
            if (product.getSku() == sku) {
                return product;
            }
        }
        return null;
    }

    // Display All Products
    private static void displayAllProducts() {
        System.out.println("\n--- All Products ---");
        if (products.isEmpty()) {
            System.out.println("No products avalible.");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
            System.out.println();
            }
    }
}
