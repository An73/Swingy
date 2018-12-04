package views.console;

/**
 * Created by dkotenko on 11/20/18.
 */
public class StartView {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void startWindow(){
        System.out.print("\033\143");
        System.out.print(
                ANSI_YELLOW + "    _______________________________________________\n" +
                ANSI_YELLOW + "   |  " + ANSI_RED + "              <<<--SWINGY-->>>           " + ANSI_YELLOW + "    |\n" +
                "   |                                               |\n" +
                "   | 1.          <--- Create a HERO --->           |\n" +
                "   |                                               |\n" +
                "   | 2. <--- Select a previously created HERO ---> |\n" +
                "   |                                               |\n" +
                "   | 3.              <--- Exit --->                |\n" +
                "   |                                               |\n" +
                "   |_______________________________________________|\n" +
                 ANSI_YELLOW + "    Input: ");
    }
}
