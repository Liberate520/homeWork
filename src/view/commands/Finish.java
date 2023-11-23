package view.commands;

import view.View;

public class Finish  extends Command {

    public Finish(View view) {
        super("Finish", view);
    }

    public void execute(){
        getView().finish();
    }
}
