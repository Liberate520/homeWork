package ui.menu;

import java.util.ArrayList;
import java.util.List;

import ui.ConsoleOne;
import ui.menu.commands.AddTreeEntity;
import ui.menu.commands.Exit;
import ui.menu.commands.PrintTree;
import ui.menu.commands.ShowEntityInfo;

public class Menu {
    private List<Option> commands;
    private ConsoleOne console;

    public Menu(ConsoleOne console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new PrintTree(console));
        commands.add(new AddTreeEntity(console));
        commands.add(new ShowEntityInfo(console));
        commands.add(new Exit(console));
    }

    public void execute(int num) {
        Option option = commands.get(num);
        option.execute();
    }

    public String stringMenu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i + 1).append(" - ");
            sb.append(commands.get(i).description());
            sb.append("\n");
        }
        return sb.toString();
    }
}
