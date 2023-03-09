package ui.commands.commandsStartMenu;

import ui.Console;
import ui.commands.Option;

public class CreateNewTree extends Option{
    public CreateNewTree(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Создать новое дерево.";
    }

    @Override
    public void execute() {
        getConsole().createNewTree();
    }
}