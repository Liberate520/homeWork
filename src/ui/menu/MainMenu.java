package ui.menu;

import java.util.ArrayList;
import java.util.List;

import ui.Console;
import ui.commands.AddHuman;
import ui.commands.Command;
import ui.commands.Exit;
import ui.commands.Load;
import ui.commands.RemoveHuman;
import ui.commands.Save;
import ui.commands.ShowGenderStatistics;
import ui.commands.ShowInfo;
import ui.commands.ShowShortInfo;

public class MainMenu {
    private List<Command> listCommands;
    private Console console;

    private MainMenu(List<Command> list, Console console) {
        this.listCommands = list;
        this.console = console;
    }

    public MainMenu(Console console) {
        this(new ArrayList<>(), console);
        listCommands.add(new AddHuman(console));
        listCommands.add(new RemoveHuman(console));
        listCommands.add(new ShowInfo(console));
        listCommands.add(new ShowShortInfo(console));
        listCommands.add(new ShowGenderStatistics(console));
        listCommands.add(new Save(console));
        listCommands.add(new Load(console));
        listCommands.add(new Exit(console));

    }

    public String show() {
        int size = listCommands.size();
        if (size > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nВыберите один из пунктов меню: \n");
            for (int i = 0; i < size; i++) {
                stringBuilder.append(i + 1);
                stringBuilder.append(". ");
                stringBuilder.append(listCommands.get(i).getDescription());
                stringBuilder.append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
        return null;
    }

    public void execute(String numCommand) {
        if (numCommand != null) {
            listCommands.get(Integer.parseInt(numCommand) - 1).execute();
        }
    }

}
