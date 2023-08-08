package family_tree.view.console_commands;

import java.util.Scanner;

public class ConsoleAddParents {
   private TextConsole textConsole;
   private Scanner scanner;
   private IsNumeric isNumeric;
   private long idChildren;
   private long idFather;
   private long idMother;

    public ConsoleAddParents() {
        this.textConsole = new TextConsole();
        this.scanner = new Scanner(System.in);
        this.isNumeric = new IsNumeric();
    }

    public long getIdChildren() {
        return idChildren;
    }

    public long getIdFather() {
        return idFather;
    }

    public long getIdMother() {
        return idMother;
    }

    public boolean addParents() {
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
