package ui;
import java.util.ArrayList;
import java.util.List;

import ui.commands.createHumanCommands.CreateHuman;
import ui.commands.createHumanCommands.CreateOriginHuman;
import ui.commands.getHumanInfoCommands.GetHumanName;
import ui.commands.getHumanInfoCommands.GetHumanSurname;
import ui.commands.getHumanTreeCommands.GetAllHumanRelations;

public class Menu {
    private List<Ioptions> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new CreateHuman(console));
        commands.add(new CreateOriginHuman(console));
        commands.add(new GetHumanName(console));
        commands.add(new GetHumanSurname(console));
        commands.add(new GetAllHumanRelations(console));
    }

    boolean execute(int num){
        Ioptions option = commands.get(num-1);
        return option.execute();
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(": ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
