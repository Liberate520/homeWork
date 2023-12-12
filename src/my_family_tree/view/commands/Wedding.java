package my_family_tree.view.commands;

import my_family_tree.view.View;

public class Wedding extends Command {

    public Wedding(View view) {
        super("Свадьба", view);
    }

    public void execute(){
        view.wedding();
    }
}