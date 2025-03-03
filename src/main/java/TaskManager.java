import Task.*;
import Exception.*;


import java.util.ArrayList;

public class TaskManager {
    public static final String LINE_SEPARATOR = "____________________________________________________________";

    private final ArrayList<Task> taskList;
    private final Ui ui;

    public TaskManager(Ui ui) {
        taskList = new ArrayList<>();
        this.ui = ui;
    }

    public void printTaskList() {
        ui.printList(taskList);
    }

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

    public void addTodo(String line) {
        String[] splitLine = line.split(" ", 2);
        String todoDescription = (splitLine.length > 1) ? splitLine[1] : ""; // If no description, use empty string
        taskList.add(new Todo(todoDescription));
        ui.printTaskAddedMessage(taskList);
    }

    public void addDeadline(String line) throws IllegalFormatException {
        line = line.substring(9);
        String[] splitLine = line.split("/by", 2);  // Split into two parts: description and deadline
        if (splitLine.length < 2) {
            throw new IllegalFormatException("Invalid deadline format. Please use the format: <description> /by <date>");
        }
        taskList.add(new Deadline(splitLine[0].trim(), splitLine[1].trim()));
        ui.printTaskAddedMessage(taskList);
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
        taskList.add(new Event(splitLine[0].trim(), timeRange[0].trim(), timeRange[1].trim()));
        ui.printTaskAddedMessage(taskList);
    }

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

        ui.printTaskDeletedMessage(taskNumber,taskList);
        taskList.remove(taskNumber);
    }





    public int getTaskCount() {
        return taskList.size();
    }

    public String getTask(int i) {
        return taskList.get(i).toString();
    }

    public void addTask(Task task) {
        //taskList.add(task);
        taskList.add(task);
    }



}
