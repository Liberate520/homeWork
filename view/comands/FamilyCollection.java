package view.comands;

import view.Console;

public class FamilyCollection extends Command {
    public FamilyCollection(Console console) {
        super(console);
    }

    public String getDescription() {
        return "Посмотреть дерево";
    }

    public void execute() {
        console.FamilyCollection();
    }

}

