package view.commands;

import view.View;

public class GetTreeInfo implements Command{
    private View view;

    public GetTreeInfo(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Вывод полной информации по дереву";
    }

    @Override
    public void execute() {
        view.getTreeInfo();
    }
}
