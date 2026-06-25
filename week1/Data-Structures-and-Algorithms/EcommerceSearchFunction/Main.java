import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {

        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String name) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int compare = products[mid].productName.compareToIgnoreCase(name);

            if (compare == 0) {
                return products[mid];
            }

            if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Mouse", "Accessories"),
                new Product(104, "Keyboard", "Accessories"),
                new Product(105, "Monitor", "Electronics")
        };

        // Linear Search
        Product result1 = linearSearch(products, "Mouse");

        if (result1 != null) {
            System.out.println("Linear Search:");
            System.out.println(result1.productId + " " +
                    result1.productName + " " +
                    result1.category);
        }

        // Sort array for Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        // Binary Search
        Product result2 = binarySearch(products, "Mouse");

        if (result2 != null) {
            System.out.println("\nBinary Search:");
            System.out.println(result2.productId + " " +
                    result2.productName + " " +
                    result2.category);
        }

        // Analysis
        System.out.println("\nTime Complexity");
        System.out.println("Linear Search : Best O(1), Average O(n), Worst O(n)");
        System.out.println("Binary Search : Best O(1), Average O(log n), Worst O(log n)");

        System.out.println("\nBinary Search is more suitable for large sorted datasets because it searches much faster.");
    }
}