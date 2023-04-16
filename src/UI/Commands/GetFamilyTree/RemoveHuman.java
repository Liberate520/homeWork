package UI.Commands.GetFamilyTree;

import FamilyTree.FamilyTree;
import Human.Human;
import UI.Commands.Command;
import UI.Console;

public class RemoveHuman extends Command {

    FamilyTree<Human> familyTree;
    public RemoveHuman(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Удалить человека";
    }

    @Override
    public void execute() {
        getConsole().removeHuman();
    }

    public Human getHuman(String name, String surname) {
        return this.getHuman(name, surname);
    }
}
