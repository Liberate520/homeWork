package View.Commands;

import View.ConsoleUI;

public class GoodBye extends Command {

    public GoodBye(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    @Override
    public void execute() {
        consoleUI.saveTree();
        consoleUI.goodbye();
    }
    
}
