package Service;
import Entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        products.add(new Product(name, price, stock));
        System.out.println("Product added successfully.");
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    public void searchOrUpdateProduct(Scanner scanner) {
        System.out.print("Search by (1) ID or (2) Name? ");
        int option = scanner.nextInt();
        scanner.nextLine();

        Product product = null;

        if (option == 1) {
            System.out.print("Enter product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            product = findProductById(id);
        } else if (option == 2) {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            product = findProductByName(name);
        }

        if (product != null) {
            System.out.println("Product found: " + product);
            System.out.print("Update (1) Price or (2) Stock or (0) Cancel? ");
            int updateOption = scanner.nextInt();
            scanner.nextLine();

            switch (updateOption) {
                case 1 -> {
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    product.setPrice(newPrice);
                    System.out.println("Price updated.");
                }
                case 2 -> {
                    System.out.print("Enter new stock: ");
                    int newStock = scanner.nextInt();
                    scanner.nextLine();
                    if (newStock >= 0) {
                        product.setStock(newStock);
                        System.out.println("Stock updated.");
                    } else {
                        System.out.println("Stock cannot be negative.");
                    }
                }
                case 0 -> System.out.println("Update cancelled.");
                default -> System.out.println("Invalid option.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(Scanner scanner) {
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product product = findProductById(id);
        if (product != null) {
            System.out.print("Are you sure you want to delete this product? (y/n): ");
            char confirm = scanner.nextLine().toLowerCase().charAt(0);
            if (confirm == 'y') {
                products.remove(product);
                System.out.println("Product deleted.");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    public Product findProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }

        return null;
    }

    public Product findProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
}
