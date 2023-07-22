package ui;

import java.util.ArrayList;
import java.util.List;

import ui.comands.AddChild;
import ui.comands.AddHuman;
import ui.comands.Command;
import ui.comands.Finish;
import ui.comands.GetHumanList;
import ui.comands.LoadFile;
import ui.comands.SaveFile;
import ui.comands.SearchName;
import ui.comands.SortByAge;
import ui.comands.SortByName;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleView consoleView) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleView));
        commandList.add(new AddChild(consoleView));
        commandList.add(new GetHumanList(consoleView));
        commandList.add(new SearchName(consoleView));
        commandList.add(new SortByName(consoleView));
        commandList.add(new SortByAge(consoleView));
        commandList.add(new SaveFile(consoleView));
        commandList.add(new LoadFile(consoleView));
        commandList.add(new Finish(consoleView));
    }

    public String menu() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            str.append(i + 1);
            str.append(" ");
            str.append(commandList.get(i).getDiscription());
            str.append("\n");
        }
        return str.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}
