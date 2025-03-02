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

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    /**
     * Prints the list of all tasks currently in the task list.
     * If no tasks are present, a message indicating that no tasks have been added will be shown.
     */
    public void printTaskList() {
        System.out.println(LINE_SEPARATOR);
        if (taskList.isEmpty()) {
            System.out.println("No tasks added");
        } else {
            for (Task task : taskList) {
                System.out.print((taskList.indexOf(task) + 1) + ".");
                System.out.println(task);
            }
        }
        System.out.println(LINE_SEPARATOR);
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

        String[] splitLine = line.split(" ");
        int taskNumber;
        taskNumber = Integer.parseInt(splitLine[1]) - 1;

        if (taskList.isEmpty()) {
            throw new InvalidInputException("No tasks added. Please add a task first.");
        } else if (taskNumber < 0 || taskNumber >= taskList.size()) {
            throw new InvalidInputException("Task number out of range.");
        }

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

        String[] splitLine = line.split(" ");
        int taskNumber;
        taskNumber = Integer.parseInt(splitLine[1]) - 1;

        if (taskList.isEmpty()) {
            throw new InvalidInputException("No tasks added. Please add a task first.");
        } else if (taskNumber < 0 || taskNumber >= taskList.size()) {
            throw new InvalidInputException("Task number out of range.");
        }

        taskList.get(taskNumber).markAsIncomplete();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Task has been marked as incomplete:");
        System.out.println(taskList.get(taskNumber));
        System.out.println(LINE_SEPARATOR);
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
        printTaskAddedMessage();
    }

    /**
     * Adds a Deadline task to the task list.
     *
     * @param line The input line containing the command and description, including the deadline.
     * @throws IllegalFormatException If the deadline format is invalid.
     */
    public void addDeadline(String line) throws IllegalFormatException {
        line = line.substring(9);
        String[] splitLine = line.split("/by", 2);  // Split into two parts: description and deadline
        if (splitLine.length < 2) {
            throw new IllegalFormatException("Invalid deadline format. Please use the format: <description> /by <date>");
        }
        taskList.add(new Deadline(splitLine[0].trim(), splitLine[1].trim()));
        printTaskAddedMessage();
    }

    /**
     * Adds an Event task to the task list.
     *
     * @param line The input line containing the command, description, and time range.
     * @throws IllegalFormatException If the event format or time range is invalid.
     */
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
        taskList.add(new Event(splitLine[0].trim(), timeRange[0].trim(), timeRange[1].trim()));
        printTaskAddedMessage();
    }

    /**
     * Deletes a task from the task list based on the provided task number.
     *
     * @param line The input line containing the command, expected to be in the format: "delete <task number>"
     * @throws NumberFormatException If the task number is not a valid integer.
     * @throws InvalidInputException If the input is invalid or the task number is out of range.
     */
    public void deleteTask(String line) throws NumberFormatException, InvalidInputException {
        if (line.length() < 8) {
            throw new InvalidInputException("Please enter a valid input. Use the format: delete <task number>");
        }

        String[] splitLine = line.split(" ");

        int taskNumber;
        taskNumber = Integer.parseInt(splitLine[1]) - 1;

        if (taskList.isEmpty()) {
            throw new InvalidInputException("No tasks added. Nothing to remove.");
        } else if (taskNumber < 0 || taskNumber >= taskList.size()) {
            throw new InvalidInputException("Task number out of range.");
        }

        printTaskDeletedMessage(taskNumber);
        taskList.remove(taskNumber);
    }

    private void printTaskAddedMessage() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.get(taskList.size() - 1));
        System.out.println("Now you have " + (taskList.size()) + " tasks in the list.");
        System.out.println(LINE_SEPARATOR);
    }

    private void printTaskDeletedMessage(int i) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskList.get(i));
        System.out.println("Now you have " + (taskList.size() - 1) + " tasks in the list.");
        System.out.println(LINE_SEPARATOR);
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



}
