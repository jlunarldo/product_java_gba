package Exception;

public class AppException extends Exception {
    public AppException(String message) {
        super(message);
    }

    // Exception when a product is not found
    public static class ProductNotFoundException extends AppException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    // Exception when stock is insufficient
    public static class InsufficientStockException extends AppException {
        public InsufficientStockException(String message) {
            super(message);
        }
    }

    // Exception when input is invalid
    public static class InvalidInputException extends AppException {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
