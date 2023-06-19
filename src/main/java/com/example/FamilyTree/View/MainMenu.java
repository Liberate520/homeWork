package com.example.FamilyTree.View;

import com.example.FamilyTree.View.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(View view) {
        commandList = new ArrayList<>();
        commandList.add(new AddRecord(view));
        commandList.add(new DeleteRecord(view));
        commandList.add(new ModifyRecord(view));
        commandList.add(new ViewRecord(view));
        commandList.add(new ShowRelatives(view));
        commandList.add(new Quit(view));
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int size(){
        return commandList.size();
    }
}