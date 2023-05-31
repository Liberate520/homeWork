package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class GetAllTrees extends ConsoleCommand implements Command {
    public GetAllTrees(View view) {
       this.view = view;
   }

    @Override
    public String getDescription() {
        return "Показать все деревья";
    }

    @Override
    public void execute() {
        view.getAllTrees();
    }
}
