import Task.Task;

import java.util.ArrayList;

/**
 * Handles user interaction by displaying messages and task lists.
 */
public class Ui {

    public static final String LINE_SEPARATOR = "____________________________________________________________";

    /**
     * Prints the greeting message when the program starts.
     */
    public void printGreeting() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm Echo");
        System.out.println("What can I do for you?");
        System.out.println("Type 'bye' to exit.");
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Prints the goodbye message when the program exits.
     */
    public void printGoodbye() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Prints the list of tasks.
     *
     * @param taskList The list of tasks to be displayed.
     */
    public void printList(ArrayList<Task> taskList) {
        System.out.println(LINE_SEPARATOR);
        if (taskList.isEmpty()) {
            System.out.println("No tasks in list.");
        } else {
            for (Task task : taskList) {
                System.out.print((taskList.indexOf(task) + 1) + ".");
                System.out.println(task);
            }
        }
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Prints a message confirming that a task has been added.
     *
     * @param taskList The list of tasks after the new task is added.
     */
    public void printTaskAddedMessage(ArrayList<Task> taskList) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.get(taskList.size() - 1));
        System.out.println("Now you have " + (taskList.size()) + " tasks in the list.");
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Prints a message confirming that a task has been deleted.
     *
     * @param i        The index of the deleted task.
     * @param taskList The list of tasks after the deletion.
     */
    public void printTaskDeletedMessage(int i, ArrayList<Task> taskList) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskList.get(i));
        System.out.println("Now you have " + (taskList.size() - 1) + " tasks in the list.");
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Prints a message indicating whether a task was marked as done or unmarked.
     *
     * @param taskList   The list of tasks.
     * @param taskNumber The index of the task being marked/unmarked.
     * @param line       The message indicating whether the task was marked or unmarked.
     */
    public void printMarkAndUnmark(ArrayList<Task> taskList, int taskNumber, String line) {
        System.out.println(LINE_SEPARATOR);
        System.out.println(line);
        System.out.println(taskList.get(taskNumber));
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Prints the list of tasks that match the search
     */
    public void printFoundTasks(ArrayList<Task> taskList) {
        System.out.println(LINE_SEPARATOR);
        if (taskList.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            for (Task task : taskList) {
                System.out.print((taskList.indexOf(task) + 1) + ".");
                System.out.println(task);
            }
        }
        System.out.println(LINE_SEPARATOR);
    }
}
