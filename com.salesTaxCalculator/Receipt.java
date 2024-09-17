import java.util.List;

public class Receipt {
    private List<Product> products;
    private TaxCalculator taxCalculator;

    public Receipt(List<Product> products, TaxCalculator taxCalculator) {
        this.products = products;
        this.taxCalculator = taxCalculator;
    }
  
    public void generateReceipt() {
        double totalTax = 0.0;
        double totalPrice = 0.0;

        
        for (Product product : products) {
            double tax = taxCalculator.calculateTax(product);
            double finalPrice = product.getPrice() + tax;
            totalTax += tax;
            totalPrice += finalPrice;
            System.out.printf("%s: %.2f%n", product.getName(), finalPrice);
        }

        System.out.printf("Sales Taxes: %.2f%n", totalTax);
        System.out.printf("Total: %.2f%n", totalPrice);
    }
}
