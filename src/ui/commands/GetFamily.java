package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class GetFamily extends ConsoleCommand implements Command {
    public GetFamily(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Показать семейное дерево";
    }

    @Override
    public void execute() {
        view.getFamily();
    }
}
