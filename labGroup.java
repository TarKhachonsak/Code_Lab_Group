class labGroup {
    public static void main(String[] args) {
        
    }
}

 class Product {
    String productId;
    String name;
    double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price + " THB");
    }
}
 class Smartphone extends Product {
    String OS;

    public Smartphone(String productId, String name, double price, String OS) {
        super(productId, name, price);
        this.OS = OS;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Operating System : " + OS);
    }
}
 class Clothing extends Product {
    String size;

    public Clothing(String productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Size: " + size);
    }
}
 import java.util.ArrayList;

class Store {
    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.name);
    }

    Product findProduct(String productId) {
        for (Product product : products) {
            if (product.productId.equals(productId)) {
                return product;
            }
        }
        return null;
    }

    void listProducts() {
        for (Product product : products) {
            product.displayInfo();
            System.out.println();
        }
    }
}
 import java.util.Scanner;

 public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Product Store Menu:");
            System.out.println("1. Add Product to store");
            System.out.println("2. List Products");
            System.out.println("3. Find Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addProductToStore(store, scanner);
                    break;
                case 2:
                    store.listProducts();
                    break;
                case 3:
                    findProductInStore(store, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addProductToStore(Store store, Scanner scanner) {
        System.out.println("Enter product type [1 for Smartphone, 2 for Clothing]: ");
        int prdType = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        if (prdType == 1) {
            System.out.print("Enter OS: ");
            String OS = scanner.nextLine();
            Smartphone smartphone = new Smartphone(productId, name, price, OS);
            store.addProduct(smartphone);
        } else if (prdType == 2) {
            System.out.print("Enter Size: ");
            String size = scanner.nextLine();
            Clothing clothing = new Clothing(productId, name, price, size);
            store.addProduct(clothing);
        } else {
            System.out.println("Invalid product type.");
        }
    }

    static void findProductInStore(Store store, Scanner scanner) {
        System.out.print("Enter Product ID to find: ");
        String productId = scanner.nextLine();
        Product product = store.findProduct(productId);

        if (product != null) {
            product.displayInfo();
        } else {
            System.out.println("Product not found.");
        }
    }
}

