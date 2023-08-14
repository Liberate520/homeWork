package FamilyTree.Tree.view;


import FamilyTree.Tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;
public class MainMenu {
    private List<Command> commandList;
    private ConsoleUI consoleUI;

    public MainMenu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        commandList = new ArrayList<>();
        commandList.add(new readFam(consoleUI));
        commandList.add(new addHumans(consoleUI));
        commandList.add(new addChildren(consoleUI));
        commandList.add(new addParent(consoleUI));
        commandList.add(new GetHumansInfo(consoleUI));
        commandList.add(new sortName(consoleUI));
        commandList.add(new sortPatronymic(consoleUI));
        commandList.add(new sortDateOfBirth(consoleUI));
        commandList.add(new saveFam(consoleUI));
        commandList.add(new Finish(consoleUI));

    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\t    Меню    \n\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public void execute(int numCommand, String path) {
        Command command = commandList.get(numCommand - 1);
        command.execute(path);
    }

    public int size() {
        return commandList.size();
    }


}