package ui.commands.getHumanInfoCommands;

import ui.Commands;
import ui.Console;
import ui.commands.setCommands.SetHuman;

public class GetHumanSurname extends Commands {

    public GetHumanSurname(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Получить фамилию человека человека";
    }

    @Override
    public boolean execute() {
        Integer index = new SetHuman(console).getIndex();
        System.out.println(Console.humans.get(index).surname);
        return true;
    }
}
