package ru.gb.model.node.commands;

import ru.gb.model.node.TreeItem;

public abstract class Command {
    String description;
    TreeItem treeItem;


    public Command(String description, TreeItem treeItem) {
        this.description = description;
        this.treeItem = treeItem;
    }

    public String getDescription() {
        return description;
    }

    public TreeItem getTreeItem() {
        return treeItem;
    }

    public abstract void execute();
}
