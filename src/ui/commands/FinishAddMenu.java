package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class FinishAddMenu extends FinishMenu implements Command {
    public FinishAddMenu(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Назад";
    }

    @Override
    public void execute() {

    }
}
