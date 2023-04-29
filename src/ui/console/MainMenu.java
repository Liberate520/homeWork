package ui.console;

import ui.View;
import ui.console.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new AddMember(view));
        commandList.add(new GetFamily(view));
        commandList.add(new GetRelatives(view));
        commandList.add(new Save(view));
        commandList.add(new Load(view));
        commandList.add(new Finish(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public void execute(int numCommand) throws IOException, ClassNotFoundException {
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }
}
