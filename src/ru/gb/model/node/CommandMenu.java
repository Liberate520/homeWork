package ru.gb.model.node;

import ru.gb.model.node.commands.Command;
import ru.gb.model.node.commands.FalseAnswerCommand;
import ru.gb.model.node.commands.TrueAnswerCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandMenu {
    List<Command> commands;

    public CommandMenu(TreeItem treeItem) {
        commands = new ArrayList<>();

        commands.add(new TrueAnswerCommand(treeItem));
        commands.add(new FalseAnswerCommand(treeItem));
    }
}
