package classes.view.commands;

import classes.view.ConsoleUI;

public class TestInput extends Command {
    public TestInput(ConsoleUI consoleUI) {
        super(consoleUI);
        String description = "Тестовый список(создание)";
    }

    public void execute(){
        consoleUI.TestInput();
    }
}
