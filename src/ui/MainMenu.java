package ui;

import ui.commands.*;
import ui.commands.mainMenu.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    private ViewMainMenu viewMainMenu;
    private boolean activeTree;
    private String nameTree;

    public MainMenu(ViewMainMenu viewMainMenu){
        this.viewMainMenu = viewMainMenu;
        commandList = new ArrayList<>();
        commandList.add(new AddFamilyTree(viewMainMenu));
        commandList.add(new ReadFamilyTree(viewMainMenu));
        commandList.add(new WriteFamilyTree(viewMainMenu));
        commandList.add(new WorkWithTree(viewMainMenu));
        commandList.add(new Finish(viewMainMenu));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < commandList.size(); i++){
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
    public void execute(int numCommand){
        commandList.get(numCommand-1).execute();
    }

    public int size(){
        return commandList.size();
    }

}
