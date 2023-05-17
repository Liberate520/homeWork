package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class FinishTreeMenu extends FinishMenu implements Command {
    public FinishTreeMenu(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Выйти из семейного дерева";
    }
    @Override
    public void execute() {
        view.finishTreeMenu();
    }
}
