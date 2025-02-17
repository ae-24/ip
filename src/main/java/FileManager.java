import Task.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    private final File data;
    private final TaskManager taskManager;

    public FileManager(TaskManager taskManager) {
        this.taskManager = taskManager;
        String homeDirectory = System.getProperty("user.home");

        // Create a path to save the file in the home directory
        Path filePath = Paths.get(homeDirectory, "Echo.txt");

        // Create a File object using the constructed path
        data = filePath.toFile();

        try {
            if (data.createNewFile()) {
                System.out.println("New Save created");

            } else {
                System.out.println("Loading Save...");
                loadSaveFile();
            }
        } catch (IOException e) {
            // Handle exception
            System.out.println("An error occurred while creating the file.");
        }
    }

    public void loadSaveFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(data);
        Task taskToAdd;



        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.charAt(line.indexOf("[") + 1) == 'T') {
                int start = line.indexOf("]") + 5;
                taskToAdd = new Todo(line.substring(start));
                markAndAddTask(line, taskToAdd);

            } else if (line.charAt(line.indexOf("[") + 1) == 'D') {
                int start = line.indexOf("] ") + 2;
                int byIndex = line.indexOf("(by:");

                String taskDescription = line.substring(start, byIndex - 1);
                String byContent = line.substring(byIndex + 5, line.length() - 1);
                taskToAdd = new Deadline(taskDescription, byContent);
                markAndAddTask(line, taskToAdd);

            } else if (line.charAt(line.indexOf("[") + 1) == 'E') {
                int start = line.indexOf("] ") + 2;
                int fromIndex = line.indexOf("(from:");
                int toIndex = line.indexOf("to:");

                String taskDescription = line.substring(start, fromIndex - 1);
                String fromDate = line.substring(fromIndex + 7, toIndex - 1);
                String toDate = line.substring(toIndex + 4, line.length() - 1);
                taskToAdd = new Event(taskDescription, fromDate, toDate);
                markAndAddTask(line, taskToAdd);
            }
        }

        scanner.close();

    }

    private void markAndAddTask(String line, Task taskToAdd) {
        if (line.charAt(line.indexOf("[") + 4) == 'X') {
            taskToAdd.markAsComplete();
        }
        taskManager.addTask(taskToAdd);
    }

    public void updateSaveFile() {
        try (PrintWriter writer = new PrintWriter(data)) {
            for (int i = 0; i < taskManager.getTaskCount(); i++) {
                writer.println((i + 1) + ". " + taskManager.getTask(i));
            }
            System.out.println("Tasks have been saved to the file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

}
