import Entities.Order;
import Entities.Product;
import Service.OrderService;
import Service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductService productService = new ProductService();
    private static final OrderService orderService = new OrderService(productService);

    public static void main(String[] args) {

        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> productService.addProduct(scanner);
                case 2 -> productService.listProducts();
                case 3 -> productService.searchOrUpdateProduct(scanner);
                case 4 -> productService.deleteProduct(scanner);
                case 5 -> orderService.createOrder(scanner);
                case 6 -> orderService.listOrders();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    private static void showMenu() {
        System.out.println("\n--- Product & Order Management System ---");
        System.out.println("1. Add Product");
        System.out.println("2. List Products");
        System.out.println("3. Search/Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Create Order");
        System.out.println("6. List Orders");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
        //agregando commentarios
    }
}