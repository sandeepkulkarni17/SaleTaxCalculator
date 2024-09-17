import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {
    private static final double BASIC_SALES_TAX_RATE = 0.10;
    private static final double IMPORT_DUTY_RATE = 0.05;

    
    public double calculateTax(Product product) {
        double tax = 0.0;
        
        if (!product.isExempt()) {
            tax += product.getPrice() * BASIC_SALES_TAX_RATE;
        }
        
        if (product.isImported()) {
            tax += product.getPrice() * IMPORT_DUTY_RATE;
        }

        return roundToNearestFiveCents(tax);
    }

    private double roundToNearestFiveCents(double amount) {
        BigDecimal bd = new BigDecimal(amount);
        bd = bd.setScale(2, RoundingMode.UP);
        return Math.ceil(bd.doubleValue() * 20.0) / 20.0;
    }
}
