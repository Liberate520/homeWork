package ui.allMenuList;

import java.util.ArrayList;
import ui.Console;
import ui.commands.Command;
import ui.commands.commandsMainMenu.AddTreeElement;
import ui.commands.commandsMainMenu.ShowTree;
import ui.commands.commandsMainMenu.SortTree;
import ui.commands.commandsMainMenu.EndWork;
import ui.commands.commandsMainMenu.FindTreeElement;
import ui.commands.commandsMainMenu.ImportTree;
import ui.commands.commandsMainMenu.SaveTree;

public class MainMenu implements MenuOptionable{
    private ArrayList<Command> commands;
    private Console console;

    public MainMenu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new ShowTree(console));
        commands.add(new AddTreeElement(console));
        commands.add(new FindTreeElement(console));
        commands.add(new SortTree(console));
        commands.add(new SaveTree(console));
        commands.add(new ImportTree(console));
        commands.add(new EndWork(console));
    }

    @Override
    public ArrayList<Command> getCommands() {
        return commands;
    }
}