import Task.Task;

import java.util.ArrayList;

public class Ui {

    public static final String LINE_SEPARATOR = "____________________________________________________________";

    public  Ui() {}

    public void printGreeting() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm Echo");
        System.out.println("What can I do for you?");
        System.out.println("Type 'bye' to exit.");
        System.out.println(LINE_SEPARATOR);
    }

    public void printGoodbye() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE_SEPARATOR);
    }

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

    public void printTaskAddedMessage(ArrayList<Task> taskList) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.get(taskList.size() - 1));
        System.out.println("Now you have " + (taskList.size()) + " tasks in the list.");
        System.out.println(LINE_SEPARATOR);
    }

    public void printTaskDeletedMessage(int i, ArrayList<Task> taskList) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskList.get(i));
        System.out.println("Now you have " + (taskList.size() - 1) + " tasks in the list.");
        System.out.println(LINE_SEPARATOR);
    }


}
