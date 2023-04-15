package ui.comands;

import ui.Console;

public class AddMemberToTree extends Command{

    public AddMemberToTree(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить нового члена семьи";
    }

    @Override
    public boolean execute() {
        return getConsole().AddMemberToTree();
    }
}
