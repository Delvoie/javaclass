import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1) Create Product");
            System.out.println("2) Create Perishable Product");
            System.out.println("3) Edit Product by SKU");
            System.out.println("4) Delete Product by SKU");
            System.out.println("5) Display Product by SKU");
            System.out.println("6) Display All Products");
            System.out.println("7) Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createProduct(false);
                case 2 -> createProduct(true);
                case 3 -> editProduct();
                case 4 -> deleteProduct();
                case 5 -> displayProduct();
                case 6 -> displayAllProducts();
                case 7 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }

    private static void createProduct(boolean isPerishable) {
        try {
            System.out.print("Enter SKU (8+ digits): ");
            long sku = scanner.nextLong();
            scanner.nextLine();

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter unit cost: ");
            double unitCost = scanner.nextDouble();

            System.out.print("Enter sale price: ");
            double salePrice = scanner.nextDouble();

            System.out.print("Enter quantity on hand: ");
            int quantityOnHand = scanner.nextInt();

            System.out.print("Enter quantity needed: ");
            int quantityNeeded = scanner.nextInt();

            scanner.nextLine();
            System.out.print("Enter special instructions: ");
            String specialInstructions = scanner.nextLine();

            if (isPerishable) {
                System.out.print("Enter expiry date (YYYY-MM-DD): ");
                LocalDate expiryDate = LocalDate.parse(scanner.nextLine());
                products.add(new PerishableProduct(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions, expiryDate));
            } else {
                products.add(new Product(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions));
            }
            System.out.println("Product added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void editProduct() {
        System.out.print("Enter SKU of the product to edit: ");
        long sku = scanner.nextLong();
        scanner.nextLine(); // Consume newline
    
        Product productToEdit = findProductBySKU(sku);
        if (productToEdit == null) {
            System.out.println("Product not found.");
            return;
        }
    
        System.out.println("Current product details:");
        System.out.println(productToEdit);
    
        try {
            System.out.print("Enter new product name (press Enter to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) productToEdit.setName(name);
    
            System.out.print("Enter new unit cost (press Enter to keep current): ");
            String unitCostStr = scanner.nextLine();
            if (!unitCostStr.isEmpty()) productToEdit.setUnitCost(Double.parseDouble(unitCostStr));
    
            System.out.print("Enter new sale price (press Enter to keep current): ");
            String salePriceStr = scanner.nextLine();
            if (!salePriceStr.isEmpty()) productToEdit.setSalePrice(Double.parseDouble(salePriceStr));
    
            System.out.print("Enter new quantity on hand (press Enter to keep current): ");
            String quantityOnHandStr = scanner.nextLine();
            if (!quantityOnHandStr.isEmpty()) productToEdit.setQuantityOnHand(Integer.parseInt(quantityOnHandStr));
    
            System.out.print("Enter new quantity needed (press Enter to keep current): ");
            String quantityNeededStr = scanner.nextLine();
            if (!quantityNeededStr.isEmpty()) productToEdit.setQuantityNeeded(Integer.parseInt(quantityNeededStr));
    
            System.out.print("Enter new special instructions (press Enter to keep current): ");
            String specialInstructions = scanner.nextLine();
            if (!specialInstructions.isEmpty()) productToEdit.setSpecialInstructions(specialInstructions);
    
            if (productToEdit instanceof PerishableProduct) {
                System.out.print("Enter new expiry date (YYYY-MM-DD, press Enter to keep current): ");
                String expiryDateStr = scanner.nextLine();
                if (!expiryDateStr.isEmpty()) {
                    ((PerishableProduct) productToEdit).setExpiryDate(LocalDate.parse(expiryDateStr));
                }
            }
    
            System.out.println("Product updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }
    
    private static void deleteProduct() {
        System.out.print("Enter SKU of the product to delete: ");
        long sku = scanner.nextLong();
        scanner.nextLine(); // Consume newline
    
        Product productToDelete = findProductBySKU(sku);
        if (productToDelete == null) {
            System.out.println("Product not found.");
            return;
        }
    
        products.remove(productToDelete);
        System.out.println("Product deleted successfully.");
    }
    
    private static void displayProduct() {
        System.out.print("Enter SKU of the product to display: ");
        long sku = scanner.nextLong();
        scanner.nextLine(); // Consume newline
    
        Product productToDisplay = findProductBySKU(sku);
        if (productToDisplay == null) {
            System.out.println("Product not found.");
            return;
        }
    
        System.out.println(productToDisplay);
    }
    
    private static Product findProductBySKU(long sku) {
        for (Product product : products) {
            if (product.getSku() == sku) {
                return product;
            }
        }
        return null;
    }

    private static void displayAllProducts() {
        System.out.println("\n--- All Products ---");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}