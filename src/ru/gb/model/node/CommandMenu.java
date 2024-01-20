package ru.gb.model.node;

import ru.gb.model.node.commands.Command;
import ru.gb.model.node.commands.FalseAnswerCommand;
import ru.gb.model.node.commands.TrueAnswerCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandMenu {
    List<Command> commands;

    public CommandMenu() {
        commands = new ArrayList<>();

        commands.add(new TrueAnswerCommand());
        commands.add(new FalseAnswerCommand());
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public boolean execute(int choice) {
        Command command = commands.get(choice - 1);
        return command.execute();
    }
}
