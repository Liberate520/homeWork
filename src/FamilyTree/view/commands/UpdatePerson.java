package FamilyTree.view.commands;

import FamilyTree.view.ConsoleUI;

public class UpdatePerson implements Command{
    private ConsoleUI consoleUI;

    public UpdatePerson(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getCommandDescription() {
        return "Обновить запись о человеке";
    }

    @Override
    public void execute() {
        consoleUI.updatePerson();
    }
}
