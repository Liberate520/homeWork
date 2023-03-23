package ui.commands;

import ui.Console;

public class Open extends Command{
    public Open (Console console){
        super(console);
    }    

    @Override
    public String description() {
        return "Загрузить древо";
    }

    @Override
    public void execute() {
        getConsole().open();
    }
}
