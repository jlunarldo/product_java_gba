package Exception;

public class AppException extends Exception {
    public AppException(String message) {
        super(message);
    }


    public static class ProductNotFoundException extends AppException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }


    public static class InsufficientStockException extends AppException {
        public InsufficientStockException(String message) {
            super(message);
        }
    }


    public static class InvalidInputException extends AppException {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
