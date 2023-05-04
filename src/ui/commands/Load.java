package ui.commands;

import ui.Console;

public class Load implements Command {
    Console console;

    public Load(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.load();
        
    }

    @Override
    public String getDescription() {
        return "Загрузить сохраненное генеалогическое дерево";
    }
    

    
}

