import controllers.ConsoleController;
import controllers.SwingController;
import dbService.DBService;

/**
 * Created by dkotenko on 11/20/18.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleController consoleController;
        SwingController swingController;
        DBService dbService = new DBService();
        dbService.create();
        consoleController = new ConsoleController(dbService);
        swingController = new SwingController(dbService);

        if (args.length != 1)
            System.out.println("error args.length != 1");
        else if (args[0].equals("console"))
            consoleController.startConsole();
        else if (args[0].equals("gui"))
            swingController.startGUI();

    }
}
