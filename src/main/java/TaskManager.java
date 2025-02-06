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
                taskList[i].printTask();
            }
        }
        System.out.println(LINE_SEPARATOR);
    }

    public void markTaskAsComplete(String line) {
        String[] splitLine = line.split(" ");
        int taskNumber = Integer.parseInt(splitLine[1]) - 1;
        taskList[taskNumber].markAsComplete();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Task has been marked as done:");
        taskList[taskNumber].printTask();
        System.out.println(LINE_SEPARATOR);
    }

    public void markTaskAsIncomplete(String line) {
        String[] splitLine = line.split(" ");
        int taskNumber = Integer.parseInt(splitLine[1]) - 1;
        taskList[taskNumber].markAsIncomplete();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Task has been marked as incomplete:");
        taskList[taskNumber].printTask();
        System.out.println(LINE_SEPARATOR);
    }

    public void addTask(String line) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("added: " + line);
        System.out.println(LINE_SEPARATOR);
        taskList[taskCount] = new Task(line);
        taskCount++;
    }
}
