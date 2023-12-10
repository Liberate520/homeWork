package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.ConsoleUI;

public class Finish extends Command {

    public Finish(ConsoleUI view) {
        super("Потушили свет!", view);
    }

    public void execute(){
        getView().finish();
    }
}
