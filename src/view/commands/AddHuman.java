package view.commands;

import view.View;

public class AddHuman extends Command{
    public AddHuman(View view) {
        super(view, "Добавление человека");
    }

    @Override
    public void execute() {
        getView().addHuman();
    }
}
