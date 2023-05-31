package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class NewFamilyTree extends ConsoleCommand implements Command {
    public NewFamilyTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Новое семейное дерево";
    }

    @Override
    public void execute() {
        view.createFamilyTree();
    }
}
