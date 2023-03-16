package ui.Commands;

import java.io.IOException;

import ui.View;

public class Search extends Command {

    public Search(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Найти человека";
    }

    @Override
    public void execute() throws ClassNotFoundException, IOException {
        getView().getData().put("name", getView().getName("пользователя"));
        getView().getData().put("surname", getView().getSurname("пользователя"));
        getView().getPresenter().Search(getView().getData());
    }

}
