package ui.Commands;

import java.io.IOException;

import ui.View;

public class ShowList extends Command {

    public ShowList(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Показать семейное древо";
    }

    @Override
    public void execute() throws ClassNotFoundException, IOException {
        getView().getPresenter().showList();
    }
}
