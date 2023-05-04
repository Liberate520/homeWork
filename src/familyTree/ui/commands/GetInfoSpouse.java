package familyTree.ui.commands;

import familyTree.ui.View;

public class GetInfoSpouse implements Command{
    private View view;
    public GetInfoSpouse(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Информация о супругах";
    }

    @Override
    public void execute() {
        view.getInfoSpouse();
    }
}