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


    // Getters and Setters - W3schools.com. Java Encapsulation. (2024). https://www.w3schools.com/java/java_encapsulation.asp
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
        this.name = name;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }


    @Override
    public String toString() {
        return "SKU: " + sku +
                "\nProduct Name: " + name +
                "\nUnit Cost: $" + unitCost +
                "\nSale Price: $" + salePrice +
                "\nQuantity on hand: " + quantityOnHand +
                "\nQuantity Needed: " + quantityNeeded +
                "\nSpecial Instructions: " + specialInstructions;
    }
}