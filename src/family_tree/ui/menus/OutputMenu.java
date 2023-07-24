package family_tree.ui.menus;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;
import family_tree.ui.commands.GetItemByName;
import family_tree.ui.commands.GetTree;
import family_tree.ui.commands.GetTreeShort;
import family_tree.ui.commands.sort.SortTree;

import java.util.ArrayList;
import java.util.List;

public class OutputMenu {
    private List<Command> commandsList;

    public OutputMenu(ConsoleView consoleView) {
        commandsList = new ArrayList<>();
        commandsList.add(new GetTree(consoleView));
        commandsList.add(new GetTreeShort(consoleView));
        commandsList.add(new GetItemByName(consoleView));
        commandsList.add(new SortTree(consoleView));
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getSize(); i++) {
            sb.append(i + 1).append(". ");
            sb.append(commandsList.get(i).getDescription());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public void execute(int option, String data) {
        Command command = commandsList.get(option - 1);
        command.execute(data);
    }

    public int getSize() {
        return commandsList.size();
    }

}
