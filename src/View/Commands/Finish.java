package View.Commands;

import View.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "End of work";
    }

    public void execute(){
        consoleUI.finish();
    }
}
