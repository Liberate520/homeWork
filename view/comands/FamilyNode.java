package view.comands;

import view.Console;

public class FamilyNode extends Command {

    public FamilyNode(Console console) {
        super(console);
    }

    public String getDescription() {
        return "Создать родственную связь";
    }

    public void execute() {
        console.FamilyNode();
    }

}
