package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleView consoleView){
        commandList = new ArrayList<>();
        commandList.add(new GetTreeInfo(consoleView));
        commandList.add(new AddHuman(consoleView));
        commandList.add(new AddKid(consoleView));
        commandList.add(new AddParent(consoleView));
        commandList.add(new AddPartner(consoleView));
        commandList.add(new SortByName(consoleView));
        commandList.add(new SortBYAge(consoleView));
        commandList.add(new SortByBirthday(consoleView));
        commandList.add(new SearchHuman(consoleView));
        commandList.add(new SaveInFile(consoleView));
        commandList.add(new LoadFromFile(consoleView));
        commandList.add(new Finish(consoleView));
    }
    public int getSize() {
        return commandList.size();
    }
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< commandList.size(); i++){
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString() ;
    }

    public void execute(int choice) {
        Command command = commandList.get(choice-1);
        command.execute();
        System.out.println("  <><><><><><><><><><><><>");
    }
}
