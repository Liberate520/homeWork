package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class ChangeFather extends Command2{
    public ChangeFather(View2 view2){
        super("Change father?", view2);
    }
    @Override
    public void execute() {
        getView2().changeFather();
    }
}
