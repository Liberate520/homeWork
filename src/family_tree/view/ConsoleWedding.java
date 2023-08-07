package family_tree.view;

import java.util.Scanner;

public class ConsoleWedding {
    private TextConsole textConsole = new TextConsole();
    private Scanner scanner = new Scanner(System.in);
    private IsNumeric isNumeric = new IsNumeric();
    private long idHusband;
    private long idWife;

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
