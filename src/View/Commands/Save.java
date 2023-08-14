package View.Commands;

import javax.lang.model.element.ExecutableElement;

import View.ConsoleUI;

public class Save extends Command{
    public Save(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Save to file";
    }

    public void execute(){
        consoleUI.save();
    }
}
