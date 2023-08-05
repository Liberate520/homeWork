package src;

package src.view;

import src.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
//        AddHuman
//        AddChild
//        GetHumansInfo
//        SortByName
//        SortByAge
//        LoadHumansFromFile
//        SaveHumansToFile
//        Finish
    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new Finish(consoleUI));
        commandList.add(new AddHuman(consoleUI));

        commandList.add(new  AddChild(consoleUI));
        commandList.add(new  GetHumansInfo(consoleUI));
        commandList.add(new  SortByName(consoleUI));
        commandList.add(new  SortByAge(consoleUI));
        commandList.add(new  LoadHumansFromFile(consoleUI));
        commandList.add(new  SaveHumansToFile(consoleUI));
//        commandList.add(new  (consoleUI));
    }

    public String menu(){
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

    public int getSize(){
        return commandList.size();
    }

}
