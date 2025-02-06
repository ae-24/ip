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
                continue;
            } else if (line.toLowerCase().startsWith("mark")) {
                taskManager.markTaskAsComplete(line);
                continue;
            } else if (line.toLowerCase().startsWith("unmark")) {
                taskManager.markTaskAsIncomplete(line);
                continue;
            }
            taskManager.addTask(line);

        }
        in.close();
    }
}
