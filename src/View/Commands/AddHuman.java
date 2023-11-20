package View.Commands;

import View.View;

public class AddHuman extends Command{
    public AddHuman(View view) {
        super(view, "Добавление человека");
    }

    @Override
    public void execute() {
        getView().addHuman();
    }
}
