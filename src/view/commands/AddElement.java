package view.commands;

import view.View;

public class AddElement extends Command {

        public AddElement(View view) {
        super("Add element", view);
    }

    public void execute(){
        getView().addElement();
    }
}
