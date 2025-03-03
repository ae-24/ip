import Task.Task;
import Task.Todo;
import Task.Deadline;
import Task.Event;
import Exception.*;


import java.util.ArrayList;

/**
 * Manages tasks by storing, updating, and removing them.
 * Provides functionality to add, mark, unmark, find, and delete tasks.
 * Tasks can be of type Todo, Deadline, or Event.
 */
public class TaskManager {
    public static final String LINE_SEPARATOR = "____________________________________________________________";

    private final ArrayList<Task> taskList;
    private final Ui ui;

    public TaskManager(Ui ui) {
        taskList = new ArrayList<>();
        this.ui = ui;
    }

    /**
     * Prints the list of all tasks currently in the task list.
     * If no tasks are present, a message indicating that no tasks have been added will be shown.
     */
    public void printTaskList() {
        ui.printList(taskList);
    }

    /**
     * Marks a task as complete based on the provided task number.
     *
     * @param line The input line containing the command, expected to be in the format: "mark <task number>"
     * @throws NumberFormatException If the task number is not a valid integer.
     * @throws InvalidInputException If the input is invalid or the task number is out of range.
     */
    public void markTaskAsComplete(String line) throws NumberFormatException, InvalidInputException {
        if (line.length() < 6) {
            throw new InvalidInputException("Please enter a valid input. Use the format: mark <task number>");
        }

        int taskNumber = getTaskNumber(line, "Please enter a valid input. Use the format: mark <task number>");

        taskList.get(taskNumber).markAsComplete();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Task has been marked as done:");
        System.out.println(taskList.get(taskNumber));
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Marks a task as incomplete based on the provided task number.
     *
     * @param line The input line containing the command, expected to be in the format: "unmark <task number>"
     * @throws NumberFormatException If the task number is not a valid integer.
     * @throws InvalidInputException If the input is invalid or the task number is out of range.
     */
    public void markTaskAsIncomplete(String line) throws NumberFormatException, InvalidInputException {
        if (line.length() < 8) {
            throw new InvalidInputException("Please enter a valid input. Use the format: unmark <task number>");
        }

        int taskNumber = getTaskNumber(line, "Please enter a valid input. Use the format: unmark <task number>");

        taskList.get(taskNumber).markAsIncomplete();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Task has been marked as incomplete:");
        System.out.println(taskList.get(taskNumber));
        System.out.println(LINE_SEPARATOR);
    }

    private int getTaskNumber(String line, String message) throws InvalidInputException {
        String[] splitLine = line.split(" ");
        if (splitLine.length < 2) {
            throw new InvalidInputException(message);
        }
        int taskNumber;
        taskNumber = Integer.parseInt(splitLine[1]) - 1;

        if (taskList.isEmpty()) {
            throw new InvalidInputException("No tasks added. Please add a task first.");
        } else if (taskNumber < 0 || taskNumber >= taskList.size()) {
            throw new InvalidInputException("Task number out of range.");
        }
        return taskNumber;
    }

    /**
     * Adds a Todo task to the task list.
     *
     * @param line The input line containing the command and description of the task.
     */
    public void addTodo(String line) {
        String[] splitLine = line.split(" ", 2);
        String todoDescription = (splitLine.length > 1) ? splitLine[1] : ""; // If no description, use empty string
        taskList.add(new Todo(todoDescription));
        ui.printTaskAddedMessage(taskList);
    }

    /**
     * Adds a Deadline task to the task list.
     *
     * @param line The input line containing the command and description, including the deadline.
     * @throws IllegalFormatException If the deadline format is invalid.
     */
    public void addDeadline(String line) throws IllegalFormatException, InvalidInputException {
        if (line.length() < 9) {
            throw new InvalidInputException("Please enter a valid input. Use the format: deadline <description> /by <date>");
        }
        line = line.substring(9);
        String[] splitLine = line.split("/by", 2);  // Split into two parts: description and deadline
        if (splitLine.length < 2) {
            throw new IllegalFormatException("Invalid deadline format. Please use the format: <description> /by <date>");
        }
        taskList.add(new Deadline(splitLine[0].trim(), splitLine[1].trim()));
        ui.printTaskAddedMessage(taskList);
    }

    /**
     * Adds an Event task to the task list.
     *
     * @param line The input line containing the command, description, and time range.
     * @throws IllegalFormatException If the event format or time range is invalid.
     */
    public void addEvent(String line) throws IllegalFormatException, InvalidInputException {
        if (line.length() < 6) {
            throw new InvalidInputException("Please enter a valid input. Use the format: event <description> /from <start> /to <end>");
        }
        line = line.substring(6);
        String[] splitLine = line.split("/from", 2);  // Split into two parts: description and time range
        if (splitLine.length < 2) {
            throw new IllegalFormatException("Invalid event format. Please use the format: event <description> /from <start> /to <end>");
        }
        String[] timeRange = splitLine[1].split("/to", 2);  // Split the time range by "/to" to get the start and end time
        if (timeRange.length < 2) {
            throw new IllegalFormatException("Invalid event time format. Please use the format: /from <start> /to <end>");
        }
        taskList.add(new Event(splitLine[0].trim(), timeRange[0].trim(), timeRange[1].trim()));
        ui.printTaskAddedMessage(taskList);
    }

    /**
     * Deletes a task from the task list based on the provided task number.
     *
     * @param line The input line containing the command, expected to be in the format: "delete <task number>"
     * @throws NumberFormatException If the task number is not a valid integer.
     * @throws InvalidInputException If the input is invalid or the task number is out of range.
     */
    public void deleteTask(String line) throws NumberFormatException, InvalidInputException, ArrayIndexOutOfBoundsException {
        if (line.length() < 8) {
            throw new InvalidInputException("Please enter a valid input. Use the format: delete <task number>");
        }

        String[] splitLine = line.split(" ");

        int taskNumber;
        if (splitLine.length < 2) {
            throw new InvalidInputException("Please enter a valid input. Use the format: delete <task number>");
        }
        taskNumber = Integer.parseInt(splitLine[1]) - 1;
        if (taskList.isEmpty()) {
            throw new InvalidInputException("No tasks added. Nothing to remove.");
        } else if (taskNumber < 0 || taskNumber >= taskList.size()) {
            throw new InvalidInputException("Task number out of range.");
        }

        ui.printTaskDeletedMessage(taskNumber,taskList);
        taskList.remove(taskNumber);
    }





    /**
     * Returns the total number of tasks in the task list.
     *
     * @return The number of tasks in the task list.
     */
    public int getTaskCount() {
        return taskList.size();
    }

    /**
     * Returns a string representation of a task at the specified index.
     *
     * @param i The index of the task.
     * @return A string representation of the task at the specified index.
     */
    public String getTask(int i) {
        return taskList.get(i).toString();
    }

    public void addTask(Task task) {
        //taskList.add(task);
        taskList.add(task);
    }

    public void find(String line) throws InvalidInputException {
        if (line.length() < 5) {
            throw new InvalidInputException("Please enter a valid input. Use the format: find <description>");
        }
        String[] splitLine = line.split(" ", 2);
        if (splitLine.length < 2) {
            throw new InvalidInputException("Please enter a valid input. Use the format: find <description>");
        }

        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getDescription().toLowerCase().contains(splitLine[1].toLowerCase())) {
                foundTasks.add(task);
            }
        }
        if (foundTasks.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            printList(foundTasks);
        }
    }

    private static void printList(ArrayList<Task> foundTasks) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Here are the matching tasks in your list:");
        for (Task task : foundTasks) {
            System.out.print((foundTasks.indexOf(task) + 1) + ".");
            System.out.println(task);
        }
        System.out.println(LINE_SEPARATOR);
    }

}
