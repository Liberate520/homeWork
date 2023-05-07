package ui;

import ui.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private  List<Command> commands;
    public Menu(Console console){
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new AddMother(console));
        commands.add(new AddFather(console));
        commands.add(new AddChild(console));
        commands.add(new GetHumanTree(console));
        commands.add(new SearchHuman(console));
        commands.add(new SearchParents(console));
        commands.add(new SearchChild(console));
        commands.add(new Save(console));
        commands.add(new PrintFile(console));
        commands.add(new DeleteHuman(console));
        commands.add(new ClearTree(console));
        commands.add(new Finish(console));


    }
    public void execute(int choice) {
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
