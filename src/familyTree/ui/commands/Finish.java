package familyTree.ui.commands;

import familyTree.ui.View;

public class Finish implements Command{
    private View view;
    public Finish(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Завершение работы";
    }

    @Override
    public void execute() {
        view.finish();
    }
}