package family_tree.view.console_commands;

import java.util.Scanner;

public class ConsoleWedding {
    private TextConsole textConsole;
    private Scanner scanner;
    private IsNumeric isNumeric;
    private long idHusband;
    private long idWife;

    public ConsoleWedding() {
        this.textConsole = new TextConsole();
        this.scanner = new Scanner(System.in);
        this.isNumeric = new IsNumeric();
    }

    public long getIdHusband() {
        return idHusband;
    }

    public long getIdWife() {
        return idWife;
    }

    public boolean wedding() {
        System.out.println(textConsole.enterHusbandIdText);
        String husband = scanner.nextLine();
        if (!isNumeric.checkNum(husband)) {
            System.out.println(textConsole.idErrText);
            return false;
        }
        idHusband = Integer.parseInt(husband);

        System.out.println(textConsole.enterWifeIdText);
        String wife = scanner.nextLine();
        if (!isNumeric.checkNum(wife)) {
            System.out.println(textConsole.idErrText);
            return false;
        }
        idWife = Integer.parseInt(wife);
        return true;
    }
}
