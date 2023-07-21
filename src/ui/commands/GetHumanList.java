package Tree.homeWork.src.ui.commands;

import Tree.homeWork.src.ui.View;
public class GetHumanList implements Command {
    private View view;
    public GetHumanList(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Получить список людей";
    }

    @Override
    public void execute() {
        view.getHumanList();
    }
}
