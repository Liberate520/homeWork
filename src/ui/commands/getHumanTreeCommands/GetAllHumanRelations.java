package ui.commands.getHumanTreeCommands;

import familyTree.Tree;
import human.Family;
import human.Human;
import ui.Commands;
import ui.Console;
import ui.commands.setCommands.SetHuman;

public class GetAllHumanRelations extends Commands {

    public GetAllHumanRelations(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Получить семейное дерево человека";
    }

    @Override
    public boolean execute() {
        Integer index = new SetHuman(console).getIndex();
        Tree<Human<Family>> humantree = new Tree<Human<Family>>(Console.humans.get(index-1));
        System.out.println(humantree.relations);
        return true;
    }
}