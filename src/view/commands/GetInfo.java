package view.commands;

import view.View;

public class GetInfo implements Command{
    private View view;

    public GetInfo(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Вывод информации по персоне";
    }

    @Override
    public void execute() {
        view.getInfo();
    }
}
