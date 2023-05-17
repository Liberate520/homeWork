package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class SelectWomen extends ConsoleCommand implements Command {
    public SelectWomen(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Женский";
    }

    @Override
    public void execute() {
        view.setSex(1);
    }
}
