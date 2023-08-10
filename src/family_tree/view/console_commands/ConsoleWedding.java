package family_tree.view.console_commands;

import family_tree.view.console_commands.CommandsInterface.IConsoleWedding;

public class ConsoleWedding extends ConsoleCommands implements IConsoleWedding {

    private long idHusband;
    private long idWife;

    public long getIdHusband() {
        return idHusband;
    }

    public long getIdWife() {
        return idWife;
    }

    public boolean weddingCon() {
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
