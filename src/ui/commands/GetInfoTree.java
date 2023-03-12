package ui.commands;

import ui.Console;

public class GetInfoTree extends Command {    
    
    public GetInfoTree(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Получить информацию по всему дереву";
    }

    @Override
    public void execute() {
        System.out.println("Предоставляю информацию");
    }
}
