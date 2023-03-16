package ui.Commands;

import ui.View;

public class ShowChildren extends Command {

    public ShowChildren(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Показать список детей";
    }

    @Override
    public void execute() {
        getView().getData().put("name", getView().getName("пользователя"));
        getView().getData().put("surname", getView().getSurname("пользователя"));
        getView().getPresenter().getChildren(getView().getData());
    }

}
