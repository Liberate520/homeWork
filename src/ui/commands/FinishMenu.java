package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public abstract class FinishMenu extends ConsoleCommand {
    public FinishMenu(View view) {
        this.view = view;
    }

    abstract public String getDescription();

    abstract public void execute();
}
