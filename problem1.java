import java.util.Scanner;

class Product {
    String name;
    int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    static Product findProduct(char code) {
        switch (code) {
            case 'N':
                return new Product("Notebook", 45);
            case 'P':
                return new Product("Pen", 10);
            case 'M':
                return new Product("Marker", 25);
            case 'F':
                return new Product("File", 30);
            default:
                return null;
        }
    }
}

class Purchase {
    static int totalPurchases = 0;
    static int totalRevenue = 0;
    static int receiptNo = 001;

    Product product;
    int quantity;
    int receipt;

    Purchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.receipt = receiptNo++;

        totalPurchases++;
        totalRevenue += product.price * quantity;
    }

    int getAmount() {
        return product.price * quantity;
    }

    public String toString() {
        return "Receipt " + receipt + ": " + product.name
                + " x " + quantity + " = " + getAmount();
    }
}

public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.close();
            return;
        }

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item code and quantity: ");
            if (!sc.hasNext()) {
                System.out.println("Missing item code.");
                break;
            }

            char code = sc.next().charAt(0);
            if (!sc.hasNextInt()) {
                System.out.println("Invalid quantity for code " + code + ".");
                break;
            }

            int quantity = sc.nextInt();
            Product p = Product.findProduct(code);

            if (p == null || quantity <= 0) {
                System.out.println("Invalid item: " + code + " " + quantity);
            } else {
                Purchase purchase = new Purchase(p, quantity);
                System.out.println(purchase);
            }
        }

        System.out.println("Total receipts: " + Purchase.totalPurchases
                + ", Total revenue: " + Purchase.totalRevenue);

        sc.close();
    }
}