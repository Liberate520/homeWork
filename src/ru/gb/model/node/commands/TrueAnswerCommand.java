package ru.gb.model.node.commands;

import ru.gb.model.node.TreeItem;

public class TrueAnswerCommand extends Command {
    public TrueAnswerCommand() {
        super("Да");
    }
    
    @Override
    public boolean execute() {
        return true;
    }
}
