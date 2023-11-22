package view;

import view.command.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI console) {
        commandList = new ArrayList<>();
        commandList.add(new AddFirstParent(console));
        commandList.add(new AddHuman(console));
        commandList.add(new Finish(console));
        commandList.add(new GetHumanInfo(console));
        commandList.add(new ImportTree(console));
        commandList.add(new Load(console));
        commandList.add(new Save(console));
        commandList.add(new SortByAge(console));
        commandList.add(new SortByName(console));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
