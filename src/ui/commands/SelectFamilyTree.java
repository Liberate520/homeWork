package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class SelectFamilyTree extends ConsoleCommand implements Command {
    public SelectFamilyTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Выбрать семейное дерево";
    }

    @Override
    public void execute() {
        try {
            view.selectFamilyTree();
            view.startTreeMenu();
        }
        catch (NullPointerException e) {
            System.out.println("Данное семейное дерево отсутствует");
        }

    }
}
