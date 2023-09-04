package view.comands;

import view.Console;

public class FamilyCollection extends Command {
    public FamilyCollection(Console console) {
        super(console);
    }

    public String getDescription() {
        return "Посмотреть связи";
    }

    public void execute() {
        console.FamilyCollection();
    }

}

