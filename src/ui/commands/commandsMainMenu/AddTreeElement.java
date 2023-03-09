package ui.commands.commandsMainMenu;

import ui.Console;
import ui.commands.Option;

public class AddTreeElement extends Option{
    public AddTreeElement(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Добавить новый элемент дерева.";
    }

    @Override
    public void execute() {
        getConsole().addTreeElement();
    }
}