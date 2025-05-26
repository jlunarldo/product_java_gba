package Service;

import Entities.Order;
import Entities.OrderLine;
import Entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exception.AppException;

public class OrderService {

    private final ProductService productService;
    private final List<Order> orders = new ArrayList<>();

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public void createOrder(Scanner scanner) {
        List<OrderLine> orderLines = new ArrayList<>();
        String choice = "";

        do {
            productService.listProducts();

            try {
                System.out.print("Enter Product ID to add to order: ");
                int productId = Integer.parseInt(scanner.nextLine());

                Product product = productService.findProductById(productId);
                if (product == null) {
                    throw new AppException.ProductNotFoundException("Product not exist.");
                }

                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                if (quantity <= 0) {
                    throw new AppException.InvalidInputException("Quantity must be greater than zero.");
                }

                if (quantity > product.getStock()) {
                    throw new AppException.InsufficientStockException("Not stock available.");
                }

                product.setStock(product.getStock() - quantity);
                orderLines.add(new OrderLine(product, quantity));

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values.");
            } catch (AppException e) {
                System.out.println("Error: " + e.getMessage());
            }



            System.out.print("Add another product? 1:Yes \n 0:Return");
            choice = scanner.nextLine().toLowerCase();

        } while (choice.equals("1"));

        if (!orderLines.isEmpty()) {
            Order order = new Order(orderLines);
            orders.add(order);

            System.out.println("Order created successfully.");
            System.out.println(order);
        } else {
            System.out.println("Order was not created.");
        }
    }

    public void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders have been placed yet.");
        } else {
            for (Order o : orders) {
                System.out.println(o);
            }
        }
    }
}
