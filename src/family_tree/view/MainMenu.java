package family_tree.view;

import family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUi consoleUi) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUi));
        commandList.add(new SortByBirthDate(consoleUi));
        commandList.add(new SortByName(consoleUi));
        commandList.add(new GetInfo(consoleUi));
        commandList.add(new Finish(consoleUi));
    }
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++){
            stringBuilder.append(i+1);
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
