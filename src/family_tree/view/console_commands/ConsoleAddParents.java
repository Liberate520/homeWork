package family_tree.view.console_commands;

import family_tree.view.console_commands.CommandsInterface.IConsoleAddParents;

public class ConsoleAddParents extends ConsoleCommands implements IConsoleAddParents {
   private long idChildren;
   private long idFather;
   private long idMother;

    public long getIdChildren() {
        return idChildren;
    }

    public long getIdFather() {
        return idFather;
    }

    public long getIdMother() {
        return idMother;
    }

    public boolean addParentsCon() {
        System.out.println(textConsole.enterChildrenIdText);
        String children = scanner.nextLine();
        if (!isNumeric.checkNum(children)) {
            System.out.println(textConsole.idErrText);
            return false;
        }
        idChildren = Integer.parseInt(children);

        System.out.println(textConsole.enterFatherIdText);
        String father = scanner.nextLine();
        if (!isNumeric.checkNum(father)) {
            System.out.println(textConsole.idErrText);
            return false;
        }
        idFather = Integer.parseInt(father);

        System.out.println(textConsole.enterMotherIdText);
        String mother = scanner.nextLine();
        if (!isNumeric.checkNum(mother)) {
            System.out.println(textConsole.idErrText);
            return false;
        }
        idMother = Integer.parseInt(mother);
        return true;
    }
}
