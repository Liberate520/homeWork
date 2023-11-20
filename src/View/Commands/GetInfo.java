package View.Commands;

import View.View;

public class GetInfo extends Command {
    public GetInfo(View view) {
        super(view, "Получить список");
    }

    @Override
    public void execute() {
        getView().getFamilyList();
    }
}
