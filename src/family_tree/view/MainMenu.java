package family_tree.view;

import family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddFamilyMember(consoleUI));
        commands.add(new GetFamilyTreeMembers(consoleUI));
        commands.add(new SetWedding(consoleUI));
        commands.add(new SetFather(consoleUI));
        commands.add(new SetMother(consoleUI));
        commands.add(new GetChildrenList(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SaveTreeToFile(consoleUI));
        commands.add(new GetTreeFromFile(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commands.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}
