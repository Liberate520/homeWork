package FamilyTree.view.commands;

import FamilyTree.view.ConsoleUI;

public class AddPerson implements Command {
    private ConsoleUI consoleUI;

    public AddPerson(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getCommandDescription() {
        return "Добавить элемент дерева";
    }

    @Override
    public void execute() {
        consoleUI.addPerson();
    }
}
