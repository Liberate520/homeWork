package ui.commands;

import ui.Console;

public class Save implements Command {
    Console console;

    public Save(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.save();
        
    }

    @Override
    public String getDescription() {
              return "Cохранить текущее генеалогическое дерево";
    }

    
}



