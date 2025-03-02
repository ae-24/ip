package Exception;

/**
 * Exception thrown when a user provides input that does not match the expected format.
 */
public class IllegalFormatException extends Exception {
    public IllegalFormatException(String message) {
        super(message);
    }

    public void print() {
        System.out.println("Invalid input: " + getMessage());
    }
}
