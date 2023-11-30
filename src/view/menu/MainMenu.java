package view.menu;

import java.util.ArrayList;
import java.util.List;

import view.ConsoleUI;
import view.commands.AddHuman;
import view.commands.AddHumanRelatives;
import view.commands.Command;
import view.commands.Finish;
import view.commands.GetHumanTreeInfo;
import view.commands.SaveInFile;
import view.commands.Sorts;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddHumanRelatives(consoleUI));
        commandList.add(new GetHumanTreeInfo(consoleUI));
        commandList.add(new Sorts(consoleUI));
        commandList.add(new SaveInFile(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите действие:\n");
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
