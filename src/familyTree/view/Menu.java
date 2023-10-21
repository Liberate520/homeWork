package familyTree.view;

import familyTree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;

    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddToFamily(consoleUI));
        commandList.add(new SetParents(consoleUI));
        commandList.add(new GetFamilyInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new WriteFile(consoleUI));
        commandList.add(new ReadFile(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int user){
        Command command = commandList.get(user-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
