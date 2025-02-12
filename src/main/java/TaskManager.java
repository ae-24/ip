public class TaskManager {
    public static final String LINE_SEPARATOR = "____________________________________________________________";

    private final Task[] taskList;
    int taskCount = 0;

    public TaskManager() {
        taskList = new Task[100];
    }

    public void printTaskList() {
        System.out.println(LINE_SEPARATOR);
        if (taskCount == 0) {
            System.out.println("No tasks added");
        } else {
            for (int i = 0; i < taskCount; i++) {
                System.out.print((i + 1) + ".");
                System.out.println(taskList[i]);
            }
        }
        System.out.println(LINE_SEPARATOR);
    }

    public void markTaskAsComplete(String line) throws NumberFormatException, InvalidInputException {
        String[] splitLine = line.split(" ");
        int taskNumber;
        taskNumber = Integer.parseInt(splitLine[1]) - 1;
        if (taskCount == 0) {
            System.out.println("No tasks added. Please add a task first.");
        } else if (taskNumber < 0 || taskNumber >= taskCount) {
            throw new InvalidInputException("Task number out of range.");
        }

        taskList[taskNumber].markAsComplete();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Task has been marked as done:");
        System.out.println(taskList[taskNumber]);
        System.out.println(LINE_SEPARATOR);
    }

    public void markTaskAsIncomplete(String line) throws NumberFormatException, InvalidInputException {
        String[] splitLine = line.split(" ");
        int taskNumber;
        taskNumber = Integer.parseInt(splitLine[1]) - 1;

        if (taskCount == 0) {
            System.out.println("No tasks added. Please add a task first.");
        } else if (taskNumber < 0 || taskNumber >= taskCount) {
            throw new InvalidInputException("Task number out of range.");
        }

        taskList[taskNumber].markAsIncomplete();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Task has been marked as incomplete:");
        System.out.println(taskList[taskNumber]);
        System.out.println(LINE_SEPARATOR);
    }

    public void addTodo(String line) {
        String[] splitLine = line.split(" ", 2);
        String todoDescription = (splitLine.length > 1) ? splitLine[1] : ""; // If no description, use empty string
        taskList[taskCount] = new Todo(todoDescription);
        printTaskAddedMessage();
        taskCount++;
    }

    public void addDeadline(String line) throws IllegalFormatException {
        line = line.substring(9);
        String[] splitLine = line.split("/by", 2);  // Split into two parts: description and deadline
        if (splitLine.length < 2) {
            throw new IllegalFormatException("Invalid deadline format. Please use the format: <description> /by <date>");
        }
        taskList[taskCount] = new Deadline(splitLine[0].trim(), splitLine[1].trim());
        printTaskAddedMessage();
        taskCount++;
    }

    public void addEvent(String line) throws IllegalFormatException {
        line = line.substring(6);
        String[] splitLine = line.split("/from", 2);  // Split into two parts: description and time range
        if (splitLine.length < 2) {
            throw new IllegalFormatException("Invalid event format. Please use the format: event <description> /from <start> /to <end>");
        }
        String[] timeRange = splitLine[1].split("/to", 2);  // Split the time range by "/to" to get the start and end time
        if (timeRange.length < 2) {
            throw new IllegalFormatException("Invalid event time format. Please use the format: /from <start> /to <end>");
        }
        taskList[taskCount] = new Event(splitLine[0].trim(), timeRange[0].trim(), timeRange[1].trim());
        printTaskAddedMessage();
        taskCount++;
    }

    private void printTaskAddedMessage() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList[taskCount]);
        System.out.println("Now you have " + (taskCount + 1) + " tasks in the list.");
        System.out.println(LINE_SEPARATOR);
    }
}
