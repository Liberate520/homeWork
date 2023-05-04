package familyTree.ui.commands;

import familyTree.ui.View;

public class GetInfoDateOfBirth implements Command{
    private View view;
    public GetInfoDateOfBirth(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Информация о дате рождения";
    }

    @Override
    public void execute() {
        view.getInfoDateOfBirth();
    }
}