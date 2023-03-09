package ui.commands.commandsMainMenu;

import ui.Console;
import ui.commands.Option;

public class SaveTree extends Option{
    public SaveTree(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Сохранить дерево.";
    }

    @Override
    public void execute() {
        getConsole().saveTree();
    }
}
