import java.time.LocalDate;

public class PerishableProduct extends Product {
    private LocalDate expirationDate;

    // Parameterized constructor for PerishableProduct
    public PerishableProduct(long sku, String name, double unitCost, double salePrice, int quantityOnHand, int quantityNeeded, String specialInstructions, LocalDate expirationDate) {
        super(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
        this.expirationDate = expirationDate;
    }

    // Getter and Setter for expirationDate
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Overridden toString method to include expiration date
    @Override
    public String toString() {
        return super.toString() + "\nExpiration Date: " + expirationDate;
    }
}
