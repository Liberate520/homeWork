package ui.commands;

import ui.Console;

public class GetHuman extends Command {
    public GetHuman(Console console){
        super(console);
    }
    public String getDescription(){
        return "Получить информацию о человеке";
    }
    public void execute() {
        getConsole().getHuman();
    }
}
