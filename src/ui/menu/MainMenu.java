package ui.menu;

import java.util.ArrayList;
import java.util.List;

import ui.Console;
import ui.View;
import ui.commands.AddHuman;
import ui.commands.Command;
import ui.commands.Exit;
import ui.commands.Load;
import ui.commands.RemoveHuman;
import ui.commands.Save;
import ui.commands.ShowGenderStatistics;
import ui.commands.ShowGrandFatherInfo;
import ui.commands.ShowGrandMotherInfo;
import ui.commands.ShowFullInfo;
import ui.commands.ShowShortInfo;

public class MainMenu {
    private List<Command> listCommands;
    private View view;

    private MainMenu(List<Command> list, View view) {
        this.listCommands = list;
        this.view = view;
    }

    public MainMenu(View view) {
        this(new ArrayList<>(), view);
        listCommands.add(new AddHuman(view));
        listCommands.add(new RemoveHuman(view));
        listCommands.add(new ShowFullInfo(view));
        listCommands.add(new ShowShortInfo(view));
        listCommands.add(new ShowGenderStatistics(view));
        listCommands.add(new ShowGrandMotherInfo(view));
        listCommands.add(new ShowGrandFatherInfo(view));
        listCommands.add(new Save(view));
        listCommands.add(new Load(view));
        listCommands.add(new Exit(view));

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
