package ui.commands;

import ui.Console;

public class PrintMember extends Command{
    
    public PrintMember(Console console){
        super(console);
    }

    @Override
    public String description() {
        return "Вывести данные члена семьи";
    }

    @Override
    public void execute() {
        getConsole().printMember();
        
    }
}
