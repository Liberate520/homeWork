package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu{
    private List<Command> commandList;


    public Menu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new AddPerson(consoleUI));
        commandList.add(new GetHumanListInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new FindPerson(consoleUI));
        commandList.add(new SetMather(consoleUI));
        commandList.add(new SetFather(consoleUI));
        commandList.add(new SaveTree(consoleUI));
        commandList.add(new LoadTree(consoleUI));
        commandList.add(new Finish(consoleUI));

    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= commandList.size(); i++){
            stringBuilder.append(i);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i - 1).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public int getMenuSize(){
        return commandList.size();
    }

    public void execute (int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }

}
