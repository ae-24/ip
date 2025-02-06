import java.util.Scanner;

public class Echo {

    public static final String LINE_SEPARATOR = "____________________________________________________________";

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        InputManager inputManager = new InputManager(taskManager);

        printGreeting();

        inputManager.processInputLoop();

        printGoodbye();
    }

    private static void printGoodbye() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE_SEPARATOR);
    }

    private static void printGreeting() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm Echo");
        System.out.println("What can I do for you?");
        System.out.println("Type 'bye' to exit.");
        System.out.println(LINE_SEPARATOR);
    }
}
