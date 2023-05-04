package ui.commands;

import ui.Console;


public class ShowInfo implements Command {
    Console console;

    public ShowInfo(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.showInfo();
        
    }

    @Override
    public String getDescription() {
        return "Вывести подробную информацию по генеалогическому дереву";
    }
    
}
