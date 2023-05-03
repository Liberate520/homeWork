package ui;

import ui.commands.Command;
import ui.commands.workMenu.*;

import java.util.ArrayList;
import java.util.List;

public class WorkMenu {
    private List<Command> commandList;
    private ViewWorkMenu viewWorkMenu;
    private boolean activeTree;
    private String nameTree;

    public WorkMenu(ViewWorkMenu viewWorkMenu){
        this.viewWorkMenu = viewWorkMenu;
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(viewWorkMenu));
        commandList.add(new PrintTree(viewWorkMenu));
        commandList.add(new FindHuman(viewWorkMenu));
        commandList.add(new FindHumanById(viewWorkMenu));
        commandList.add(new BackToMainMenu(viewWorkMenu));
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
