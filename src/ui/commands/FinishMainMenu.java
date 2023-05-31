package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class FinishMainMenu extends FinishMenu implements Command{
    public FinishMainMenu(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Выйти";
    }

    @Override
    public void execute() {
        view.finishMainMenu();
    }
}
