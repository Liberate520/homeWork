package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new ShowTree(console));
        commands.add(new AddHuman(console));
        commands.add(new SortName(console));
        commands.add(new SortDate(console));
        commands.add(new Search(console));
        commands.add(new Save(console));
        commands.add(new Load(console));
        commands.add(new Exit(console));
    }

    void execute(int num){
        Option option = commands.get(num-1);
        option.execute();
    }

    public String printMenu(){
        System.out.println("Меню:");
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
