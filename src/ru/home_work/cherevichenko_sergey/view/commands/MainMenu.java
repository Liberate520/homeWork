package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUi consoleUi) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUi));
        commands.add(new GetHumanInfo(consoleUi));
        commands.add(new AddChildForFamily(consoleUi));
        commands.add(new FindChildren(consoleUi));
        commands.add(new RemoveHuman(consoleUi));
        commands.add(new SortByName(consoleUi));
        commands.add(new SortByLastName(consoleUi));
        commands.add(new SortByAge(consoleUi));
        commands.add(new SortByCountChildren(consoleUi));
        commands.add(new SaveTree(consoleUi));
        commands.add(new RestoreTree(consoleUi));
        commands.add(new Finish(consoleUi));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1)
                    .append(". ")
                    .append(commands.get(i).getDescription())
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();

    }

    public int size() {
        return commands.size();
    }
}
