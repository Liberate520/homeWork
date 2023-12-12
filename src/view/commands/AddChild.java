package homeWork.src.view.commands;

import homeWork.src.view.View;

public class AddChild extends Command {

    public AddChild(View view){
        super("Add child", view);
    }
    @Override
    public void execute() {
        getView().addChild();
    }
}
