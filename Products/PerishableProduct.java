import java.time.LocalDate;

public class PerishableProduct extends Product {
    private LocalDate expiryDate;

    public PerishableProduct() {
        super();
        expiryDate = LocalDate.now().plusDays(30); // Default to 30 days from today
    }

    public PerishableProduct(long sku, String name, double unitCost, double salePrice,
                             int quantityOnHand, int quantityNeeded, String specialInstructions,
                             LocalDate expiryDate) {
        super(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
        setExpiryDate(expiryDate);
    }

    public final LocalDate getExpiryDate() {
        return expiryDate;
    }

    public final void setExpiryDate(LocalDate expiryDate) {
        if (expiryDate == null || expiryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date must be in the future.");
        }
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nExpiry Date: " + expiryDate;
    }
}