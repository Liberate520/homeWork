package familyTree.ui.commands;

import familyTree.ui.View;

public class GetInfoGender implements Command{
    private View view;
    public GetInfoGender(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Информация о поле человека";
    }

    @Override
    public void execute() {
        view.getInfoGender();
    }
}