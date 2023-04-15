package ui;

import ui.comands.AddMemberToTree;
import ui.comands.DeleteNote;
import ui.comands.Exit;
import ui.comands.Option;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new AddMemberToTree(console));
        commands.add(new DeleteNote(console));
        commands.add(new Exit(console));
    }

    public void execute (int num){
        Option option = commands.get(num -1);
        option.execute();
    }

    public String printMenu(){
        StringBuilder  stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(":");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
            return stringBuilder.toString();
    }
}





