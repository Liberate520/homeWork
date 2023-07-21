package View.Commands;

import View.ConsoleUI;

public class AddFamily extends Command {

    public AddFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать семейные связи";
    }

    @Override
    public void execute() {
        consoleUI.addFamily();
    }
    
}