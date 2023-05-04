package familyTree.ui.commands;

import familyTree.ui.View;

public class GetInfoAge implements Command{
    private View view;
    public GetInfoAge(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Возраст человека";
    }

    @Override
    public void execute() {
        view.getInfoAge();
    }
}