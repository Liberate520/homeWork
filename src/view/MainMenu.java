package view;

import view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    public List<Command> commandList;

    public MainMenu(View view) {
        commandList = new ArrayList<>();
        commandList.add(new AddElement(view));
        commandList.add(new SortByAge(view));
        commandList.add(new SortByAge(view));
        commandList.add(new GetFamilyTree(view));
        commandList.add(new Save(view));
        commandList.add(new Read(view));
        commandList.add(new SaveAndExit(view));
        commandList.add(new Exit(view));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Menu:\n");
        for (int i=0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append(".\n");
        }
        return stringBuilder.toString();
    }

    public void execute (int choise) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choise-1);
        command.execute();
    }
    public int size() {
        return commandList.size();
    }
}
