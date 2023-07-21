package UI.Commands.ChangeInfo;

import FamilyTree.FamilyTree;
import Human.Human;
import UI.Commands.Command;
import UI.Console;

public class ChangeInfo extends Command {

    public ChangeInfo(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Изменить сведения о человеке";
    }

    @Override
    public void execute() {
        getConsole().changeInfo();
    }

}
