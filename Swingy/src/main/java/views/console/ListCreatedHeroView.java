package views.console;

import java.util.HashMap;

/**
 * Created by dkotenko on 25.11.2018.
 */
public class ListCreatedHeroView {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public void listCreatedHero (HashMap<Integer, String> players, boolean error) {
        System.out.print("\033\143");
        System.out.println(ANSI_YELLOW + "  ->>> Select player <<<-\n");
        for (int i = 0; players != null && i < players.size(); i++){
            System.out.print(ANSI_YELLOW + "    -> " + i + "  name : ");
            System.out.println(ANSI_CYAN + players.get(i));
        }
        System.out.println(ANSI_YELLOW + "    -> e  Exit");
        if (error)
            System.out.print(ANSI_RED + "  Error input. Retry ");
        System.out.print(ANSI_YELLOW + "\n  Input: ");
    }
}
