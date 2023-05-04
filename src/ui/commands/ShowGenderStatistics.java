package ui.commands;

import ui.Console;

public class ShowGenderStatistics implements Command {
    Console console;

    public ShowGenderStatistics(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.showGenderStatistics();
        
    }

    @Override
    public String getDescription() {
        return "Вывести информацию по гендеру в дереве";
    }

    
    
}
