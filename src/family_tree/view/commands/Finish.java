package family_tree.view.commands;

import family_tree.view.View;

public class Finish extends Commands {

    public Finish(View view) {
        super("Закончить работу", view);
    }

    public void execute() {
        getView().finish();
    }
}