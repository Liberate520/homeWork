package ui.Commands;

import ui.View;

public class Search extends Command{

    public Search(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Найти человека";
    }

    @Override
    public void execute() {
        getView().getData().put("selector", "search");
        getView().getData().put("name", getView().getName("пользователя"));
        getView().getData().put("surname", getView().getSurname("пользователя"));
    }
    
}
