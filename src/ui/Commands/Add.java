package ui.Commands;

import java.io.IOException;

import ui.View;

public class Add extends Command {

    public Add(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Добавить члена семьи";
    }

    @Override
    public void execute() throws ClassNotFoundException, IOException {
        getView().сompleteDatEntry();
        getView().getPresenter().Add(getView().getData());
    }

}
