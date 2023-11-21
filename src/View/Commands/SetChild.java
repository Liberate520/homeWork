package View.Commands;

import View.View;

public class SetChild extends Command {
    public SetChild(View view) {
        super(view, "Добавить ребенка");
    }

    @Override
    public void execute() {
        getView().setChild();
    }
}
