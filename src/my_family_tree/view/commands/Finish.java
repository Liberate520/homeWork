package my_family_tree.view.commands;

import my_family_tree.view.View;

public class Finish extends Command {

    public Finish(View view) {
        super("Выход", view);
    }

    public void execute() {
        view.finish();
    }
}
