package view.commands;

import view.View;

public class GetInfoRelation implements Command{
    private View view;

    public GetInfoRelation(View view) {
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
