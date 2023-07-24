package family_tree.ui.menus;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.*;
import family_tree.ui.commands.change_item_parameter.ChangeItemParameter;

import java.util.ArrayList;
import java.util.List;

public class MainMenu{
    private List<Command> commandsList;

    public MainMenu(ConsoleView consoleView) {
        commandsList = new ArrayList<>();
        commandsList.add(new OutputConsole(consoleView));
        commandsList.add(new AddToTree(consoleView));
        commandsList.add(new DelFromTree(consoleView));
        commandsList.add(new ChangeItemParameter(consoleView));
        commandsList.add(new SetTreePeakByIndex(consoleView));
        commandsList.add(new SaveTree(consoleView));
        commandsList.add(new LoadTree(consoleView));
        commandsList.add(new DelTree(consoleView));
        commandsList.add(new Exit(consoleView));
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getSize(); i++) {
            sb.append(i + 1).append(". ");
            sb.append(commandsList.get(i).getDescription());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void execute(int option, String data) {
        Command command = commandsList.get(option - 1);
        command.execute(data);
    }

    public int getSize() {
        return commandsList.size();
    }

}
