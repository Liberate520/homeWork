package family_tree.view.menu;

import java.util.ArrayList;
import java.util.List;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;
import family_tree.view.commands.FileRead;
import family_tree.view.commands.FileSave;
import family_tree.view.commands.Finish;
import family_tree.view.commands.Remove;
import family_tree.view.commands.add.AddHuman;
import family_tree.view.commands.add.AddKinship;
import family_tree.view.commands.show.ShowChildren;
import family_tree.view.commands.show.ShowParents;
import family_tree.view.commands.show.ShowSibling;
import family_tree.view.commands.sort.SortByAge;
import family_tree.view.commands.sort.SortByName;
import family_tree.view.commands.sort.SortByPatronymic;
import family_tree.view.commands.sort.SortBySurname;
import family_tree.view.commands.show.ShowFamilyTreeInfo;

public class MainMenu implements Menu{
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        this.commandList = new ArrayList<>();
        this.commandList.add(new AddHuman(consoleUI));
        this.commandList.add(new Remove(consoleUI));
        this.commandList.add(new ShowFamilyTreeInfo(consoleUI));
        this.commandList.add(new AddKinship(consoleUI));
        this.commandList.add(new ShowSibling(consoleUI));
        this.commandList.add(new ShowParents(consoleUI));
        this.commandList.add(new ShowChildren(consoleUI));
        this.commandList.add(new SortByAge(consoleUI));
        this.commandList.add(new SortByName(consoleUI));
        this.commandList.add(new SortBySurname(consoleUI));
        this.commandList.add(new SortByPatronymic(consoleUI));
        this.commandList.add(new FileSave(consoleUI));
        this.commandList.add(new FileRead(consoleUI));
        this.commandList.add(new Finish(consoleUI));
    }

    @Override
    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public int getSize() {
        return commandList.size();
    }

    @Override
    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }
}
