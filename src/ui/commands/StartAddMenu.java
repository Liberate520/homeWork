package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class StartAddMenu extends ConsoleCommand implements Command {
    public StartAddMenu(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Добавить члена семьи";
    }

    @Override
    public void execute() {
        view.startAddMenu();
    }
}
