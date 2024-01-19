package ru.gb.model.node.commands;

import ru.gb.model.node.TreeItem;

public class FalseAnswerCommand extends Command{
    public FalseAnswerCommand(TreeItem treeItem) {
        super("Нет", treeItem);
    }

    @Override
    public void execute() {}
}
