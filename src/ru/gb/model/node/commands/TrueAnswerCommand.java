package ru.gb.model.node.commands;

import ru.gb.model.node.TreeItem;

public class TrueAnswerCommand extends Command {
    public TrueAnswerCommand(TreeItem treeItem) {
        super("Да", treeItem);
    }
    
    @Override
    public void execute() {
        getTreeItem();
    }
}
