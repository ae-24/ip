package Exception;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }

    public void print() {
        System.out.println("Invalid input: " + getMessage());
    }

}
