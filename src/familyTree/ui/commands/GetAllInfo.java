package familyTree.ui.commands;

import familyTree.ui.View;

public class GetAllInfo implements Command{
    private View view;
    public GetAllInfo(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Полная информация по всем древам";
    }

    @Override
    public void execute() {
        view.getAllInfo();
    }
}