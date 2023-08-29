package View.Commands;

import View.ConsoleUI;

public class Load extends Command{
    public Load(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Load from file";
    }

    public void execute(){
        consoleUI.load();
    }
}
