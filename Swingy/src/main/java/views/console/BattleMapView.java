package views.console;

import model.ElementMap;
import model.MapModel;
import model.enemy.Enemy;
import profile.PlayerProfile;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by dkotenko on 11/23/18.
 */
public class BattleMapView {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void mapView(MapModel mapModel, PlayerProfile playerProfile, String event) {
        int y = 1;
        int borderTop;
        int borderBottom;
        ArrayList<ElementMap> maps = mapModel.getMaps();

        borderTop = 20 + playerProfile.getBorder();
        borderBottom = 20 - playerProfile.getBorder();
        System.out.print("\033\143");
        for (int i = 0; i < maps.size(); i++) {
            if (y != maps.get(i).getY()) {
                System.out.print(ANSI_YELLOW + "   |   " + ANSI_RESET);
                setInfo(y, playerProfile);
                setMapLegend(y);
                if (event != null)
                    setEvent(event, y);
                System.out.print("\n");
            }
            setElement(maps.get(i), borderTop, borderBottom);
            y = maps.get(i).getY();
        }
        System.out.print(ANSI_YELLOW + "   |   " + ANSI_RESET);
        System.out.print("\n");
        System.out.print(ANSI_YELLOW + " Input: ");
    }

    public void death(){
        System.out.print("\033\143");
        System.out.print(ANSI_RED + "You DIED\n" +
         ANSI_YELLOW +"Press \"e\" for exit\n\n" +
        ANSI_RED + "                     .ed\"\"\"\" \"\"\"$$$$be.\n" +
                "                   -\"           ^\"\"**$$$e.\n" +
                "                 .\"                   '$$$c\n" +
                "                /                      \"4$$b\n" +
                "               d  3                      $$$$\n" +
                "               $  *                   .$$$$$$\n" +
                "              .$  ^c           $$$$$e$$$$$$$$.\n" +
                "              d$L  4.         4$$$$$$$$$$$$$$b\n" +
                "              $$$$b ^ceeeee.  4$$ECL.F*$$$$$$$\n" +
                "  e$\"\"=.      $$$$P d$$$$F $ $$$$$$$$$- $$$$$$\n" +
                " z$$b. ^c     3$$$F \"$$$$b   $\"$$$$$$$  $$$$*\"      .=\"\"$c\n" +
                "4$$$$L        $$P\"  \"$$b   .$ $$$$$...e$$        .=  e$$$.\n" +
                "^*$$$$$c  %..   *c    ..    $$ 3$$$$$$$$$$eF     zP  d$$$$$\n" +
                "  \"**$$$ec   \"   %ce\"\"    $$$  $$$$$$$$$$*    .r\" =$$$$P\"\"\n" +
                "        \"*$b.  \"c  *$e.    *** d$$$$$\"L$$    .d\"  e$$***\"\n" +
                "          ^*$$c ^$c $$$      4J$$$$$% $$$ .e*\".eeP\"\n" +
                "             \"$$$$$$\"'$=e....$*$$**$cz$$\" \"..d$*\"\n" +
                "               \"*$$$  *=%4.$ L L$ P3$$$F $$$P\"\n" +
                "                  \"$   \"%*ebJLzb$e$$$$$b $P\"\n" +
                "                    %..      4$$$$$$$$$$ \"\n" +
                "                     $$$e   z$$$$$$$$$$%\n" +
                "                      \"*$c  \"$$$$$$$P\"\n" +
                "                       .\"\"\"*$$$$$$$$bc\n" +
                "                    .-\"    .$***$$$\"\"\"*e.\n" +
                "                 .-\"    .e$\"     \"*$c  ^*b.\n" +
                "          .=*\"\"\"\"    .e$*\"          \"*bc  \"*$e..\n" +
                "        .$\"        .z*\"               ^*$e.   \"*****e.\n" +
                "        $$ee$c   .d\"                     \"*$.        3.\n" +
                "        ^*$E\")$..$\"                         *   .ee==d%\n" +
                "           $.d$$$*                           *  J$$$e*\n" +
                "            \"\"\"\"\"                              \"$$$\"\n" +
        ANSI_YELLOW + "Input: ");
    }

    public void win() {
        System.out.print("\033\143");
        System.out.print(ANSI_GREEN + "You WIN\n" +
                ANSI_YELLOW +"Press \"e\" for exit\n\n" +
                ANSI_GREEN + "                           .-.\n"+
                "                          {{#}}\n"+
                "          {}               8@8\n"+
                "        .::::.             888\n"+
                "    @\\\\/W\\/\\/W\\//@         8@8\n"+
                "     \\\\/^\\/\\/^\\//     _    )8(    _\n"+
                "      \\_O_{}_O_/     (@)__/8@8\\__(@)\n"+
                " ____________________ `~\"-=):(=-\"~`\n"+
                "|<><><>  |  |  <><><>|     |.|\n"+
                "|<>      |  |      <>|     |S|\n"+
                "|<>      |  |      <>|     |'|\n"+
                "|<>   .--------.   <>|     |.|\n"+
                "|     |   ()   |     |     |P|\n"+
                "|_____| (O\\/O) |_____|     |'|\n"+
                "|     \\   /\\   /     |     |.|\n"+
                "|------\\  \\/  /------|     |U|\n"+
                "|       '.__.'       |     |'|\n"+
                "|        |  |        |     |.|\n"+
                ":        |  |        :     |N|\n"+
                " \\       |  |       /      |'|\n"+
                "  \\<>    |  |    <>/       |.|\n"+
                "   \\<>   |  |   <>/        |K|\n"+
                "    `\\<> |  | <>/'         |'|\n"+
                "      `-.|__|.-`           \\ /\n"+
                "                            ^\n" +
                ANSI_YELLOW + "Input: ");
    }

    private void setElement(ElementMap elementMap, int borderTop, int borderBottom){
        if (elementMap.isPlayer())
            System.out.print(ANSI_CYAN + " P" + ANSI_RESET);
        else if (elementMap.getEnemy() != null)
            printEnemy(elementMap.getEnemy());
        else if ((elementMap.getX() <= borderTop && elementMap.getX() >= borderBottom) &&
                (elementMap.getY() >= borderBottom && elementMap.getY() <= borderTop))
            System.out.print(ANSI_YELLOW + " \u2B1A" + ANSI_RESET);
        else
            System.out.print(ANSI_RED + " \u2B1A" + ANSI_RESET);
    }

    private void printEnemy(Enemy enemy) {
        switch (enemy.getName()) {
            case "Bone Soldier":
                System.out.print(ANSI_RED + " W" + ANSI_RESET);
                break;
            case "Swine Slasher":
                System.out.print(ANSI_RED + " S" + ANSI_RESET);
                break;
            case "Bone Courtier":
                System.out.print(ANSI_RED + " T" + ANSI_RESET);
                break;
            case "Bone Defender":
                System.out.print(ANSI_RED + " D" + ANSI_RESET);
                break;
            case "Ghoul":
                System.out.print(ANSI_RED + " G" + ANSI_RESET);
                break;
            case "The Collector":
                System.out.print(ANSI_RED + " C" + ANSI_RESET);
                break;
            case "Unclean Giant":
                System.out.print(ANSI_RED + " U" + ANSI_RESET);
                break;
        }
    }

    private void setInfo(int y, PlayerProfile playerProfile) {

        switch (y){
            case 1:
                System.out.print(ANSI_YELLOW + "Player info" + ANSI_RESET);
                break;
            case 2:
                System.out.print(ANSI_CYAN + "Name       : " + playerProfile.getName() + ANSI_RESET);
                break;
            case 3:
                System.out.print(ANSI_CYAN + "Class      : " + playerProfile.getpClass() + ANSI_RESET);
                break;
            case 4:
                System.out.print(ANSI_CYAN + "Level      : " + playerProfile.getLevel() + ANSI_RESET);
                break;
            case 5:
                System.out.print(ANSI_CYAN + "Experience : " + playerProfile.getExperience() + ANSI_RESET);
                break;
            case 6:
                System.out.print(ANSI_CYAN + "Attack     : " + playerProfile.getAttack() + ANSI_RESET);
                break;
            case 7:
                System.out.print(ANSI_CYAN + "Defense    : " + playerProfile.getDefense() + ANSI_RESET);
                break;
            case 8:
                System.out.print(ANSI_CYAN + "HitPoints  : " + playerProfile.getHitPoints() + ANSI_RESET);
                break;
            case 9:
                System.out.print(ANSI_CYAN + "Weapon     : [" + playerProfile.getWeaponName() +
                "] (+" + playerProfile.getIncAttack() + " attack)" + ANSI_RESET);
                break;
            case 10:
                System.out.print(ANSI_CYAN + "Armor      : [" + playerProfile.getArmorName() +
                        "] (+" + playerProfile.getIncDefense() + " defense)" + ANSI_RESET);
                break;
            case 11:
                System.out.print(ANSI_CYAN + "Helm       : [" + playerProfile.getHelmName() +
                        "] (+" + playerProfile.getIncHitPoints() + " hit points)" + ANSI_RESET);
                break;
            case 13:
                System.out.print(ANSI_YELLOW + "Event" + ANSI_RESET);
                break;
        }
    }

    private void setEvent(String event, int y) {
        String[] events = event.split("\n");

        switch (y) {
            case 14:
                System.out.print(events[0]);
                break;
            case 15:
                if (events.length > 1)
                    System.out.print(events[1]);
                break;
            case 16:
                if (events.length > 2)
                    System.out.print(events[2]);
                break;
            case 17:
                if (events.length > 3)
                    System.out.print(events[3]);
                break;
            case 18:
                if (events.length > 4)
                    System.out.print(events[4]);
                break;
            case 19:
                if (events.length > 5)
                    System.out.print(events[5]);
                break;
            case 20:
                if (events.length > 6)
                    System.out.print(events[6]);
                break;
            case 21:
                if (events.length > 7)
                    System.out.print(events[7]);
                break;
            case 22:
                if (events.length > 8)
                    System.out.print(events[8]);
                break;

        }
    }

    private void setMapLegend(int y) {
        switch (y) {
            case 23:
                System.out.print(ANSI_YELLOW + "Map Legend");
                break;
            case 24:
                System.out.print(ANSI_CYAN + "P - Player");
                break;
            case 25:
                System.out.print(ANSI_RED + "W - Bone Soldier");
                break;
            case 26:
                System.out.print(ANSI_RED + "S - Swine Slasher");
                break;
            case 27:
                System.out.print(ANSI_RED + "T - Bone Courtier");
                break;
            case 28:
                System.out.print(ANSI_RED + "D - Bone Defender");
                break;
            case 29:
                System.out.print(ANSI_RED + "G - Ghoul");
                break;
            case 30:
                System.out.print(ANSI_RED + "C - The Collector");
                break;
            case 31:
                System.out.print(ANSI_RED + "U - Unclean Giant");
                break;
            case 33:
                System.out.print(ANSI_YELLOW + "Control");
                break;
            case 34:
                System.out.print(ANSI_YELLOW + "\"w\" or \"north\" move to north");
                break;
            case 35:
                System.out.print(ANSI_YELLOW + "\"s\" or \"south\" move to south");
                break;
            case 36:
                System.out.print(ANSI_YELLOW + "\"d\" or \"east\" move to east");
                break;
            case 37:
                System.out.print(ANSI_YELLOW + "\"a\" or \"west\" move to west");
                break;
            case 38:
                System.out.print(ANSI_YELLOW + "\"exit\" to exit");
                break;
        }
    }

    /*private void setBattle(int y, Enemy enemy, String pvm) {

        if (pvm != null){
            String[] stringBattle = pvm.split("/");
            switch (y) {
                case 14:
                    System.out.print(ANSI_YELLOW + "BATTLE");
                    break;
                case 16:
                    System.out.print(ANSI_YELLOW + stringBattle[0]);
                    break;
                case 17:
                    System.out.print(ANSI_YELLOW + "Player Hit Points: " + stringBattle[1]);
                    break;
                case 18:
                    System.out.print(ANSI_YELLOW + "Enemy Hit Points: " + stringBattle[2]);
                    break;
            }
        }
        else {
            switch (y) {
                case 14:
                    System.out.print(ANSI_YELLOW + "To Battle    -> 'y'");
                    break;
                case 15:
                    System.out.print(ANSI_YELLOW + "To Run (50%) -> 'n'");
                    break;
                case 17:
                    System.out.print(ANSI_RED + "Enemy info");
                    break;
                case 18:
                    System.out.print(ANSI_RED + "Name        : " + enemy.getName());
                    break;
                case 19:
                    System.out.print(ANSI_RED + "Level       : " + enemy.getLevel());
                    break;
                case 20:
                    System.out.print(ANSI_RED + "Attack      : " + enemy.getAttack());
                    break;
                case 21:
                    System.out.print(ANSI_RED + "Defense     : " + enemy.getDefense());
                    break;
                case 22:
                    System.out.print(ANSI_RED + "Hit Points  : " + enemy.getHitPoints());
                    break;
            }
        }
    }*/

    /*                             ...----....
                         ..-:"''         ''"-..
                      .-'                      '-.
                    .'              .     .       '.
                  .'   .          .    .      .    .''.
                .'  .    .       .   .   .     .   . ..:.
              .' .   . .  .       .   .   ..  .   . ....::.
             ..   .   .      .  .    .     .  ..  . ....:IA.
            .:  .   .    .    .  .  .    .. .  .. .. ....:IA.
           .: .   .   ..   .    .     . . .. . ... ....:.:VHA.
           '..  .  .. .   .       .  . .. . .. . .....:.::IHHB.
          .:. .  . .  . .   .  .  . . . ...:.:... .......:HIHMM.
         .:.... .   . ."::"'.. .   .  . .:.:.:II;,. .. ..:IHIMMA
         ':.:..  ..::IHHHHHI::. . .  ...:.::::.,,,. . ....VIMMHM
        .:::I. .AHHHHHHHHHHAI::. .:...,:IIHHHHHHMMMHHL:. . VMMMM
       .:.:V.:IVHHHHHHHMHMHHH::..:" .:HIHHHHHHHHHHHHHMHHA. .VMMM.
       :..V.:IVHHHHHMMHHHHHHHB... . .:VPHHMHHHMMHHHHHHHHHAI.:VMMI
       ::V..:VIHHHHHHMMMHHHHHH. .   .I":IIMHHMMHHHHHHHHHHHAPI:WMM
       ::". .:.HHHHHHHHMMHHHHHI.  . .:..I:MHMMHHHHHHHHHMHV:':H:WM
       :: . :.::IIHHHHHHMMHHHHV  .ABA.:.:IMHMHMMMHMHHHHV:'. .IHWW
       '.  ..:..:.:IHHHHHMMHV" .AVMHMA.:.'VHMMMMHHHHHV:' .  :IHWV
        :.  .:...:".:.:TPP"   .AVMMHMMA.:. "VMMHHHP.:... .. :IVAI
       .:.   '... .:"'   .   ..HMMMHMMMA::. ."VHHI:::....  .:IHW'
       ...  .  . ..:IIPPIH: ..HMMMI.MMMV:I:.  .:ILLH:.. ...:I:IM
     : .   .'"' .:.V". .. .  :HMMM:IMMMI::I. ..:HHIIPPHI::'.P:HM.
     :.  .  .  .. ..:.. .    :AMMM IMMMM..:...:IV":T::I::.".:IHIMA
     'V:.. .. . .. .  .  .   'VMMV..VMMV :....:V:.:..:....::IHHHMH
       "IHH:.II:.. .:. .  . . . " :HB"" . . ..PI:.::.:::..:IHHMMV"
        :IP""HHII:.  .  .    . . .'V:. . . ..:IH:.:.::IHIHHMMMMM"
        :V:. VIMA:I..  .     .  . .. . .  .:.I:I:..:IHHHHMMHHMMM
        :"VI:.VWMA::. .:      .   .. .:. ..:.I::.:IVHHHMMMHMMMMI
        :."VIIHHMMA:.  .   .   .:  .:.. . .:.II:I:AMMMMMMHMMMMMI
        :..VIHIHMMMI...::.,:.,:!"I:!"I!"I!"V:AI:VAMMMMMMHMMMMMM'
        ':.:HIHIMHHA:"!!"I.:AXXXVVXXXXXXXA:."HPHIMMMMHHMHMMMMMV
          V:H:I:MA:W'I :AXXXIXII:IIIISSSSSSXXA.I.VMMMHMHMMMMMM
            'I::IVA ASSSSXSSSSBBSBMBSSSSSSBBMMMBS.VVMMHIMM'"'
             I:: VPAIMSSSSSSSSSBSSSMMBSSSBBMMMMXXI:MMHIMMI
            .I::. "H:XIIXBBMMMMMMMMMMMMMMMMMBXIXXMMPHIIMM'
            :::I.  ':XSSXXIIIIXSSBMBSSXXXIIIXXSMMAMI:.IMM
            :::I:.  .VSSSSSISISISSSBII:ISSSSBMMB:MI:..:MM
            ::.I:.  ':"SSSSSSSISISSXIIXSSSSBMMB:AHI:..MMM.
            ::.I:. . ..:"BBSSSSSSSSSSSSBBBMMMB:AHHI::.HMMI
            :..::.  . ..::":BBBBBSSBBBMMMB:MMMMHHII::IHHMI
            ':.I:... ....:IHHHHHMMMMMMMMMMMMMMMHHIIIIHMMV"
              "V:. ..:...:.IHHHMMMMMMMMMMMMMMMMHHHMHHMHP'
               ':. .:::.:.::III::IHHHHMMMMMHMHMMHHHHM"
                 "::....::.:::..:..::IIIIIHHHHMMMHHMV"
                   "::.::.. .. .  ...:::IIHHMMMMHMV"
                     "V::... . .I::IHHMMV"'
                       '"VHVHHHAHHHHMMV:"'*/
    /*System.out.println("                           .-.\n"+
            "                          {{#}}\n"+
            "          {}               8@8\n"+
            "        .::::.             888\n"+
            "    @\\\\/W\\/\\/W\\//@         8@8\n"+
            "     \\\\/^\\/\\/^\\//     _    )8(    _\n"+
            "      \\_O_{}_O_/     (@)__/8@8\\__(@)\n"+
            " ____________________ `~\"-=):(=-\"~`\n"+
            "|<><><>  |  |  <><><>|     |.|\n"+
            "|<>      |  |      <>|     |S|\n"+
            "|<>      |  |      <>|     |'|\n"+
            "|<>   .--------.   <>|     |.|\n"+
            "|     |   ()   |     |     |P|\n"+
            "|_____| (O\\/O) |_____|     |'|\n"+
            "|     \\   /\\   /     |     |.|\n"+
            "|------\\  \\/  /------|     |U|\n"+
            "|       '.__.'       |     |'|\n"+
            "|        |  |        |     |.|\n"+
            ":        |  |        :     |N|\n"+
            " \\       |  |       /      |'|\n"+
            "  \\<>    |  |    <>/       |.|\n"+
            "   \\<>   |  |   <>/        |K|\n"+
            "    `\\<> |  | <>/'         |'|\n"+
            "jgs   `-.|__|.-`           \\ /\n"+
            "                            ^");*/
}
