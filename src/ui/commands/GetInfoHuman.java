package ui.commands;

import ui.Console;

public class GetInfoHuman extends Command {
    
    public GetInfoHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Получить информацию по человеку";
    }

    @Override
    public void execute() {
        System.out.println("Предоставляю информацию");
    }
}
