import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        System.out.println("Enter the number of products:");
        int productCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < productCount; i++) {
            System.out.println("Enter product details (name, price, isImported, isExempt):");
            String name = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine());
            boolean isImported = Boolean.parseBoolean(scanner.nextLine());
            boolean isExempt = Boolean.parseBoolean(scanner.nextLine());

            Product product = new Product(name, price, isImported, isExempt);
            productList.add(product);
        }

        TaxCalculator taxCalculator = new TaxCalculator();
        Receipt receipt = new Receipt(productList, taxCalculator);

        receipt.generateReceipt();

        scanner.close();
    }
}
