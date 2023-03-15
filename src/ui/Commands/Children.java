package ui.Commands;

import ui.View;

public class Children extends Command{

    public Children(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Показать список детей";
    }

    @Override
    public void execute() {
        getView().getData().put("selector", "children");
        getView().getData().put("name", getView().getName("пользователя"));
        getView().getData().put("surname", getView().getSurname("пользователя"));
    }
    
}
