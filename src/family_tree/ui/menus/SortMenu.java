package family_tree.ui.menus;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class SortMenu {
    private List<Command> commandsList;

    public SortMenu(ConsoleView consoleView) {
        commandsList = new ArrayList<>();
        commandsList.add(new SortByName(consoleView));
        commandsList.add(new SortByNameReverse(consoleView));
        commandsList.add(new SortByAge(consoleView));
        commandsList.add(new SortByAgeReverse(consoleView));
        commandsList.add(new SortByDateBirth(consoleView));
        commandsList.add(new SortByDateBirthReverse(consoleView));
        commandsList.add(new SortByChildren(consoleView));
        commandsList.add(new SortByChildrenReverse(consoleView));
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getSize(); i++) {
            sb.append(i + 1).append(". ");
            sb.append(commandsList.get(i).getDescription());
            sb.append("\n");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

    public void execute(int option, String data) {
        Command command = commandsList.get(option);
        command.execute(data);
    }

    public int getSize() {
        return commandsList.size();
    }

}
