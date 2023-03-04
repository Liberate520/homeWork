package ui;
import ui.commands.*;
import ui.commands.interfaces.Option;

import java.io.IOException;
import java.util.*;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new WholeList(console));
        commands.add(new Search(console));
        commands.add(new Sorting(console));
        commands.add(new Save(console));
        commands.add(new Read(console));
        commands.add(new AddRecord(console));
        commands.add(new DelRecord(console));
        commands.add(new Exit(console));
    }
    void execute(int num) throws IOException, ClassNotFoundException {
        Option option = commands.get(num-1);
        option.execute();
    }
    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++){
            stringBuilder.append(i+1);
            stringBuilder.append(": ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
