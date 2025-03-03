import java.io.IOException;

public class Echo {


    public static void main(String[] args) {
        Ui ui = new Ui();
        TaskManager taskManager = new TaskManager(ui);
        FileManager fileManager = new FileManager(taskManager);
        InputManager inputManager = new InputManager(taskManager, fileManager);

        ui.printGreeting();

        inputManager.processInputLoop();

        fileManager.updateSaveFile();
        ui.printGoodbye();
    }



}
