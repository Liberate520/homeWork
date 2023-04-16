package ui.userCommands;

import ui.ConsoleUI;

public class PrintSample extends Command {

    public PrintSample(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Распечатать информацию о члене семьи";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().printMember();
    }
}
