package view.comands;

import view.Console;

public class FamilyTreeRead extends Command {
    public FamilyTreeRead(Console console) {
        super(console);
    }

    public String getDescription() {
        return "Прочитать файл";
    }

    public void execute() {
        console.FamilyTreeRead();
    }
}