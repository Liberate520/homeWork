package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.Console;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements MenuInterface {
    private List<Command> commandList;

    public MainMenu(Console console, boolean foolMenu) {
        commandList = new ArrayList<>();
        check(new AddRecord(console), foolMenu);
        check(new DeleteRecord(console), foolMenu);
        check(new ModifyRecord(console), foolMenu);
        check(new ViewRecord(console), foolMenu);
        check(new ShowRelatives(console), foolMenu);
        check(new Quit(console), foolMenu);
    }

    private void check(Command temp, boolean foolMenu){
        if (foolMenu | temp.getInMenu()) {
            commandList.add(temp);
        }
    }

    @Override
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

    @Override
    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    @Override
    public int size(){
        return commandList.size();
    }
}