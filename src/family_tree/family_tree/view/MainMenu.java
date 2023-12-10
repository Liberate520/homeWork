package family_tree.family_tree.view;

import family_tree.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetHumanListInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Finish(consoleUI));
        commandList.add(new SortById(consoleUI));
        commandList.add(new ReadFromFile(consoleUI));
        commandList.add(new SaveFromFile(consoleUI));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список команд:\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
public void execute(String choice){
        commandList.get(Integer.parseInt(choice) - 1).execute();
}
    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }
}
