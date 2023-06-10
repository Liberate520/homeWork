package tree.familyTree.view;

import tree.familyTree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {

    private List<Command> commands;

    public UserMenu(UserUI userUI) {
        commands = new ArrayList<>();
        commands.add(new GetFamilyTree(userUI));
        commands.add(new FindHuman(userUI));
        commands.add(new AddHuman(userUI));
        commands.add(new FinishWork(userUI));
    }
    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(String.format("%d. %s\n",i + 1, commands.get(i).getDescription()));
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }

    public int sizeMenu() {
        return commands.size();
    }
}
