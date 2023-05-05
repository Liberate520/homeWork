package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private  List<Command> commands;
    public Menu(Console console){
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new GetHumanTree(console));
        commands.add(new Finish(console));
        commands.add(new SearchHuman(console));

    }
    public void execute(int choice){
        commands.get(choice - 1).execute();

    }
    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append((commands.get(i).getDescription()));
            stringBuilder.append(" \n");

        }
        return stringBuilder.toString();
    }
}
