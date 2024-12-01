import java.time.LocalDate;

public class PerishableProduct extends Product {
    private LocalDate expirationDate;

    public PerishableProduct(long sku, String name, double unitCost, double salePrice, int quantityOnHand,
                             int quantityNeeded, String specialInstructions, LocalDate expirationDate) {
        super(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + ",\nExpiration Date: " + expirationDate;
    }
}
