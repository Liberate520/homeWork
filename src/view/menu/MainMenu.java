package view.menu;

import view.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(Console console) {
        commandList = new ArrayList<>();
        commandList.add(new ShowList(console));
        commandList.add(new SortByName(console));
        commandList.add(new SortByBirthDate(console));
        commandList.add(new AddHuman(console));
        commandList.add(new FindByName(console));
        commandList.add(new FindBrothers(console));
        commandList.add(new SaveToFile(console));
        commandList.add(new LoadFromFile(console));
        commandList.add(new Finish(console));
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Доступные действия:");
        stringBuilder.append("\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int size(){
        return commandList.size();
    }
}
