package view.comands;

import view.Console;

public class FamilyTreeEntry extends Command {
    public FamilyTreeEntry(Console console) {
        super(console);
    }

    public String getDescription() {
        return "Записать дерево в файл";
    }

    public void execute() {
        console.FamilyTreeEntry();
    }

}
