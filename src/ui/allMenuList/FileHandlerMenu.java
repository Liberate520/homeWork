package ui.allMenuList;

import java.util.ArrayList;
import ui.Console;
import ui.commands.Command;
import ui.commands.commandsFileHandlerMenu.FormatToTxt;

public class FileHandlerMenu implements MenuOptionable{
    private ArrayList<Command> commands;
    private Console console;

    public FileHandlerMenu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new FormatToTxt(console));
    }

    @Override
    public ArrayList<Command> getCommands() {
        return commands;
    }
}
