import java.util.Scanner;

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
            } else {
                taskManager.addTask(line);
            }


        }
        in.close();
    }
}
