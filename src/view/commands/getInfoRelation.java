package view.commands;

import view.View;

public class getInfoRelation implements Command{
    private View view;

    public getInfoRelation(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Вывод информации по родственнику персоны";
    }

    @Override
    public void execute() {
        view.getInfoRelation();
    }
}
