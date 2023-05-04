package familyTree.ui.commands;

import familyTree.ui.View;

public class GetInfoDateOfDeath implements Command{
    private View view;
    public GetInfoDateOfDeath(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Информация о дате смерти";
    }

    @Override
    public void execute() {
        view.getInfoDateOfDeath();
    }
}