package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class ChangeName extends Command2{
    public ChangeName(View2 view2){
        super("Change name?", view2);
    }
    @Override
    public void execute() {
        getView2().changeName();
    }
}
