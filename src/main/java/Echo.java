import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        Task[] taskList = new Task[100];
        int listIndex = 0;

        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Echo");
        System.out.println("What can I do for you?");
        System.out.println("Type 'bye' to exit.");
        System.out.println("____________________________________________________________");

        while (true) {
            line = in.nextLine().trim();

            if (line.equalsIgnoreCase("bye")) {
                break;
            } else if (line.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                if (listIndex == 0) {
                    System.out.println("No tasks added");
                } else {
                    for (int i = 0; i < listIndex; i++) {
                        System.out.print((i + 1) + ".");
                        taskList[i].printTask();
                    }
                }
                System.out.println("____________________________________________________________");
                continue;
            } else if (line.toLowerCase().startsWith("mark")) {
                String[] splitLine = line.split(" ");
                int taskNumber = Integer.parseInt(splitLine[1]) - 1;
                taskList[taskNumber].markAsComplete();
                System.out.println("____________________________________________________________");
                System.out.println("Task has been marked as done:");
                taskList[taskNumber].printTask();
                System.out.println("____________________________________________________________");
                continue;
            } else if (line.toLowerCase().startsWith("unmark")) {
                String[] splitLine = line.split(" ");
                int taskNumber = Integer.parseInt(splitLine[1]) - 1;
                taskList[taskNumber].markAsIncomplete();
                System.out.println("____________________________________________________________");
                System.out.println("Task has been marked as incomplete:");
                taskList[taskNumber].printTask();
                System.out.println("____________________________________________________________");
                continue;
            }
            System.out.println("____________________________________________________________");
            System.out.println("added: " + line);
            System.out.println("____________________________________________________________");
            taskList[listIndex] = new Task(line);
            listIndex++;

        }

        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
