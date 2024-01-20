package ru.gb.model.node.commands;

import ru.gb.model.node.TreeItem;

public class FalseAnswerCommand extends Command{
    public FalseAnswerCommand() {
        super("Нет");
    }

    @Override
    public boolean execute() {return false; }
}
