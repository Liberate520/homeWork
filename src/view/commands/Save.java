package view.commands;

import view.View;

public class Save extends Command{

    public Save(View view) {
        super(view, "Сохранить");
    }

    @Override
    public void execute() {
        getView().save();
    }
}
