package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class SelectMen extends ConsoleCommand implements Command {
    public SelectMen(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Мужской";
    }

    @Override
    public void execute() {
        view.setSex(0);
    }
}
