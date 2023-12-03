package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class Exit extends Command2{
    public Exit(View2 view2){
        super("Exit", view2);
    }
    @Override
    public void execute() {
        getView2().exit();
    }
}
