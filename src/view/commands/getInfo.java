package view.commands;

import view.View;

public class getInfo implements Command{
    private View view;

    public getInfo(View view) {
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
