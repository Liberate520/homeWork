package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class AddNewPerson implements Command {
    private ConsoleUI consoleUI;

    public AddNewPerson(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Добавить человека в дерево";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
//        consoleUI.addNewPerson();
    }
}
