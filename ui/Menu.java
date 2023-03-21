package ui;

import java.util.ArrayList;
import java.util.List;
import ui.commands.AddMember;
import ui.commands.AddParents;
import ui.commands.Exit;
import ui.commands.Option;
import ui.commands.PrintMember;
import ui.commands.PrintTree;

public class Menu {
    private List<Option> commands;
    private ui.Console console;

    public Menu(ui.Console console){
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new AddMember(console));
        commands.add(new AddParents(console));
        commands.add(new PrintMember(console));
        commands.add(new PrintTree(console));
        commands.add(new Exit(console));
    }

    void execute(int num){
        Option option = commands.get(num - 1);
        option.execute();
    }

    public String printMune(){
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
