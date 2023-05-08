package UI;

import UI.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(console));
        commandList.add(new GetAllInfo(console));
        commandList.add(new GetHumanList(console));
        commandList.add(new Update(console));
        commandList.add(new Finish(console));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).description());
            stringBuilder.append("\n");
        }
//        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void run(int numCommand) throws IOException {
        commandList.get(numCommand - 1).run();
    }

    public int size() {
        return commandList.size();
    }
}
