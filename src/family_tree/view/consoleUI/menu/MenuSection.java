package family_tree.view.consoleUI.menu;

import family_tree.view.consoleUI.ConsoleUi;

import java.util.ArrayList;
import java.util.List;

public class MenuSection {
    private final List<Command> commandList;
    private ConsoleUi consoleUi;

    public MenuSection(ConsoleUi consoleUi){
        commandList = new ArrayList<>();
        this.consoleUi = consoleUi;
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(" ");
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
    public void addCommand(Command command) {
        commandList.add(command);
    }

}
