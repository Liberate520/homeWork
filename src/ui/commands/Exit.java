package ui.commands;

import ui.Console;

public class Exit implements Command {
    Console console;

    public Exit(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.exit();
        
    }

    @Override
    public String getDescription() {
        return "Завершение работы";
    }

    
}
