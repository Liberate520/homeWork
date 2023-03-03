package View;

import java.util.ArrayList;
import java.util.List;

import View.Commands.Deserialization;
import View.Commands.Exit;
import View.Commands.Option;
import View.Commands.PrintTree;
import View.Commands.SearchHuman;
import View.Commands.Serialization;
import View.Commands.SortByAge;
import View.Commands.SortByName;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new PrintTree(console));
        commands.add(new SearchHuman(console));
        commands.add(new SortByAge(console));
        commands.add(new SortByName(console));
        commands.add(new Serialization(console));
        commands.add(new Deserialization(console));
        commands.add(new Exit(console));
    }

    void execute(int num){
        Option option = commands.get(num-1);
        option.execute();
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(" - ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
