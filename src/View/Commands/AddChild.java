package View.Commands;

import View.ConsoleUI;

public class AddChild extends Command {

    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка";
    }

    @Override
    public void execute() {
        consoleUI.addChild();
    }
    
}
