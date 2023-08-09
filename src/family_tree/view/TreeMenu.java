package family_tree.view;

import family_tree.view.commands.*;
import java.util.ArrayList;
import java.util.List;

public class TreeMenu {
    private List<Command> commandsList;

    public TreeMenu(ConsoleUI console) {
        commandsList = new ArrayList<>();
        commandsList.add(new AddHuman(console));
        commandsList.add(new AddMother(console));
        commandsList.add(new AddFather(console));
        commandsList.add(new FindHumanByName(console));
        commandsList.add(new FindHumanByID(console));
        commandsList.add(new ShowParentName(console));
        commandsList.add(new ShowChild(console));
        commandsList.add(new SiblingName(console));
        commandsList.add(new SortByName(console));
        commandsList.add(new SortByAge(console));
        commandsList.add(new SortByGender(console));
        commandsList.add(new ShowFamilyTree(console));
        commandsList.add(new Finish(console));
    }

    public String menu() {
        StringBuilder strbuilder = new StringBuilder();
        for (int i = 0; i < commandsList.size(); i++) {
            strbuilder.append(i + 1);
            strbuilder.append(". ");
            strbuilder.append(commandsList.get(i).getCommandDescription());
            strbuilder.append("\n");
        }
        return strbuilder.toString();
    }

    public void execute(int act) {
        Command command = commandsList.get(act - 1);
        command.execute();
    }

    public int listSize() {
        return commandsList.size();
    }
}
