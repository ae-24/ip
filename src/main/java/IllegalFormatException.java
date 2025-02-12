public class IllegalFormatException extends Exception {
    public IllegalFormatException(String message) {
        super(message);
    }

    public void print() {
        System.out.println("Invalid input: " + getMessage());
    }
}
