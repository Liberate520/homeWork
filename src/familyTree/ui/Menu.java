package familyTree.ui;

import java.util.ArrayList;
import java.util.List;

import familyTree.ui.commands.AddHuman;
import familyTree.ui.commands.Exit;
import familyTree.ui.commands.FamilyPrint;
import familyTree.ui.commands.HumanSearch;
import familyTree.ui.commands.Load;
import familyTree.ui.commands.Option;
import familyTree.ui.commands.SaveFamily;
import familyTree.ui.commands.SortAge;
import familyTree.ui.commands.SortName;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new FamilyPrint(console));
        commands.add(new HumanSearch(console));
        commands.add(new SortName(console));
        commands.add(new SortAge(console));
        commands.add(new SaveFamily(console));
        commands.add(new Load(console));
        commands.add(new Exit(console));
    }

    void execute(int num) {
        Option option = commands.get(num - 1);
        option.execute();
    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\t- =  Меню  = -\n\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Console getConsole() {
        return console;
    }

}
