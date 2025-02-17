import java.util.Scanner;
import Exception.*;

public class InputManager {
    private final TaskManager taskManager;

    public InputManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void processInputLoop() {
        String line;
        Scanner in = new Scanner(System.in);

        while (true) {
            line = in.nextLine().trim();

            try {
                if (line.equalsIgnoreCase("bye")) {
                    break;
                } else if (line.equalsIgnoreCase("list")) {
                    taskManager.printTaskList();
                } else if (line.toLowerCase().startsWith("mark")) {
                    taskManager.markTaskAsComplete(line);
                } else if (line.toLowerCase().startsWith("unmark")) {
                    taskManager.markTaskAsIncomplete(line);
                } else if (line.toLowerCase().startsWith("todo")) {
                    taskManager.addTodo(line);
                } else if (line.toLowerCase().startsWith("deadline")) {
                    taskManager.addDeadline(line);
                } else if (line.toLowerCase().startsWith("event")) {
                    taskManager.addEvent(line);
                } else if (line.toLowerCase().startsWith("thanks") || line.toLowerCase().startsWith("thx")) {
                    System.out.println("haha you too");
                } else if(line.toLowerCase().startsWith("delete")) {
                    taskManager.deleteTask(line);
                } else {
                    throw new InvalidInputException("Please try again with one of the valid commands:\nlist, todo, deadline, event, mark, unmark");
                }
            } catch (IllegalFormatException e) {
                e.print();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid number.");
            } catch (InvalidInputException e) {
                e.print();
            }


        }
        in.close();
    }
}
