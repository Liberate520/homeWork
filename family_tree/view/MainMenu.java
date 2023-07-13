package family_tree.view;

import java.util.ArrayList;
import java.util.List;

import family_tree.view.commands.AddHuman;
import family_tree.view.commands.Command;
import family_tree.view.commands.End;
import family_tree.view.commands.GetHumansInfo;
import family_tree.view.commands.GetMenInfo;
import family_tree.view.commands.GetWomenInfo;
import family_tree.view.commands.SortByYear;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetHumansInfo(consoleUI));
        commandList.add(new GetMenInfo(consoleUI));
        commandList.add(new GetWomenInfo(consoleUI));
        commandList.add(new SortByYear(consoleUI));
        commandList.add(new End(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}
