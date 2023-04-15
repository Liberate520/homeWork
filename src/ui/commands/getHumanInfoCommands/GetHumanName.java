package ui.commands.getHumanInfoCommands;

import ui.Commands;
import ui.Console;
import ui.commands.setCommands.SetHuman;

public class GetHumanName extends Commands {

    public GetHumanName(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Получить имя человека";
    }

    @Override
    public boolean execute() {

        Integer index = new SetHuman(console).getIndex();
        console.print(Console.humans.get(index).name);
        return true;
    }
    
}
