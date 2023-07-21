package UI.Commands;

import FamilyTree.FamilyTree;
import Human.Human;
import UI.Console;

public class AddHuman extends Command {

    FamilyTree<Human> familyTree;
    public AddHuman(Console console) {
        super(console);
    }

    /*public AddHuman(Console console, FamilyTree<Human> tree) {
        super(console);
        this.familyTree = tree;
    }*/

    @Override
    public String getDescription() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        getConsole().addHuman();
    }

    public Human getHuman(String name, String surname) {
        return this.getHuman(name, surname);
    }
}
