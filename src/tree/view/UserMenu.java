package tree.view;

import tree.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserMenu {

    private List<Command> commands;

    public UserMenu(UserUI userUI) {
        commands = new ArrayList<>();
        commands.add(new GetFamilyTree(userUI));
        commands.add(new FindHuman(userUI));
        commands.add(new AddHuman(userUI));
        commands.add(new AddParent(userUI));
        commands.add(new RemoveHumanFromTree(userUI));
        commands.add(new SortByName(userUI));
        commands.add(new SortByChild(userUI));
        commands.add(new SaveFile(userUI));
        commands.add(new LoadFile(userUI));
        commands.add(new FinishWork(userUI));
        commands.add(new IsDirectDescendant(userUI));
    }
    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(String.format("%d. %s\n",i + 1, commands.get(i).getDescription()));
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        commands.get(choice - 1).execute();
    }

    public int sizeMenu() {
        return commands.size();
    }
}
