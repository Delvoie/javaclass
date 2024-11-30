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

    private static void createProduct(boolean ifPerishable) {
        System.out.println("\n--- Create Product ---");
        System.out.println("Enter product SKU:");
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
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Special Instructions: ");
        String specialInstructions = scanner.nextLine();

        if (ifPerishable) {
            System.out.print("Enter expiration date YYYY-MM-DD: ");
            LocalDate expirationDate = LocalDate.parse(scanner.nextLine());
            Product perishableProduct = new PerishableProduct(sku, name, unitCost, salePrice, quantityOnHand,
                    quantityNeeded, specialInstructions, expirationDate);
            products.add(perishableProduct);
        } else {
            Product product = new Product(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded,
                    specialInstructions);
            products.add(product);
        }

        System.out.println("Product created successfully.");
    }

private static void editProduct() {
    System.out.println("\n--- Edit Product ---");
    if (products.isEmpty()) {
        System.out.println("No products to edit.");
        return;
    }
    
    System.out.print("Enter SKU of the product to edit: ");
    long sku = scanner.nextLong();
    scanner.nextLine(); // Consume newline

    Product productToEdit = findProductBySKU(sku);
    if (productToEdit == null) {
        System.out.println("Product not found.");
        return;
    }

    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    productToEdit.setName(newName);

    System.out.print("Enter new unit cost: ");
    double newUnitCost = scanner.nextDouble();
    productToEdit.setUnitCost(newUnitCost);

    System.out.print("Enter new sale price: ");
    double newSalePrice = scanner.nextDouble();
    productToEdit.setSalePrice(newSalePrice);

    System.out.print("Enter new quantity on hand: ");
    int newQuantityOnHand = scanner.nextInt();
    productToEdit.setQuantityOnHand(newQuantityOnHand);

    System.out.print("Enter new quantity needed: ");
    int newQuantityNeeded = scanner.nextInt();
    productToEdit.setQuantityNeeded(newQuantityNeeded);

    System.out.println("Product edited successfully.");
}

    private static void deleteProduct() {
        System.out.println("\n--- Delete Product ---");
        if (products.isEmpty()) {
            System.out.println("No products to delete.");
            return;
        }

        System.out.println("Enter SKU of the product to delete: ");
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
        System.out.println("\n--- Delete Product ---");
        if (products.isEmpty()) {
            System.out.println("No products to display.");
            return;
        }

        System.out.println("Enter SKU of the product to display: ");
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