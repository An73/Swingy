package views.console;

import profile.PlayerProfile;

/**
 * Created by dkotenko on 11/22/18.
 */
public class CreateHeroView {
    private static final String ANSI_YELLOW = "\u001B[33m";

    public void heroName(){
        System.out.print(ANSI_YELLOW + "Please enter Hero Name: ");
    }

    public void heroClass(){
        System.out.println(ANSI_YELLOW + "Hero class: ");
        System.out.println("Warrior >> 1 <<");
        System.out.println("Druid   >> 2 <<");
        System.out.println("Hunter  >> 3 <<");
        System.out.println("Input: ");
    }

}
