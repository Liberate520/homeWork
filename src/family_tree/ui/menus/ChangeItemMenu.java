package family_tree.ui.menus;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;
import family_tree.ui.commands.change_item_parameter.*;

import java.util.ArrayList;
import java.util.List;

public class ChangeItemMenu {
    private List<Command> commandsList;

    public ChangeItemMenu(ConsoleView consoleView) {
        commandsList = new ArrayList<>();
        commandsList.add(new SetItemFullname(consoleView));
        commandsList.add(new SetItemDateBirth(consoleView));
        commandsList.add(new SetItemDateEndlife(consoleView));
        commandsList.add(new SetItemGender(consoleView));
        commandsList.add(new SetItemMother(consoleView));
        commandsList.add(new SetItemFather(consoleView));
        commandsList.add(new SetItemChildren(consoleView));
        commandsList.add(new SetItemCommit(consoleView));
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
