package homeWork.view;

import java.util.ArrayList;
import java.util.List;

import homeWork.view.Commands.AddChildren;
import homeWork.view.Commands.AddHuman;
import homeWork.view.Commands.AddParents;
import homeWork.view.Commands.Command;
import homeWork.view.Commands.Finish;
import homeWork.view.Commands.GetHumanInfo;
import homeWork.view.Commands.SaveInFile;
import homeWork.view.Commands.SortByAge;
import homeWork.view.Commands.SortByName;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetHumanInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Finish(consoleUI));
        commandList.add(new AddChildren(consoleUI));
        commandList.add(new AddParents(consoleUI));
        commandList.add(new SaveInFile(consoleUI));

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
