//package src;

package src.view;

import src.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private boolean work;
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
        work = true;
        commandList = new ArrayList<>();
        commandList.add(new Finish(consoleUI));  //  1 ==> EXIT  +++
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddChild(consoleUI));
        commandList.add(new humanSearch(consoleUI));  // +++
        commandList.add(new GetHumansInfo(consoleUI));  // +++
        commandList.add(new SortByName(consoleUI));  // +++
        commandList.add(new SortByAge(consoleUI));  // +++
        commandList.add(new LoadHumansFromFile(consoleUI));  // +++
        commandList.add(new AppendHumansFromFile(consoleUI));  // +++
        commandList.add(new SaveHumansToFile(consoleUI));  // +++

//        commandList.add(new  (consoleUI));
    }

    public boolean work(){return work;}
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
//        if (num > 0 && num <= commands.size()){
        if (choice == 1) work = false;
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

}
