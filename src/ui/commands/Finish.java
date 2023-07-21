package Tree.homeWork.src.ui.commands;

import Tree.homeWork.src.ui.View;
public class Finish implements Command{
    private View view;
    public Finish(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Завершить";
    }
    @Override
    public void execute() {
        view.finish();
    }
}
