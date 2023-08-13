package view;

import java.util.ArrayList;
import java.util.List;

import view.Commands.AddHuman;
import view.Commands.AddKinship;
import view.Commands.Command;
import view.Commands.DelHuman;
import view.Commands.Finish;
import view.Commands.GetHumanListInfo;
import view.Commands.LoadFile;
import view.Commands.SortByAge;
import view.Commands.SortById;
import view.Commands.SortByName;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddKinship(consoleUI));
        commandList.add(new DelHuman(consoleUI));
        commandList.add(new GetHumanListInfo(consoleUI));
        commandList.add(new SortById(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new LoadFile(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<commandList.size();i++){
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int numCommand){
        Command command=commandList.get(numCommand-1);
        command.execute();
    }

    public int size(){
        return commandList.size();
    }
}
