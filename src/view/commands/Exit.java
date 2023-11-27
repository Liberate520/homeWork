package view.commands;

import view.View;

public class Exit  extends Command {

    public Exit(View view) {
        super("Finish", view);
    }

    public void execute(){
        getView().exit();
    }
}
