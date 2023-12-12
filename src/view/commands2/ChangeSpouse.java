package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class ChangeSpouse extends Command2{
    public ChangeSpouse(View2 view2){
        super("Change spouse?", view2);
    }
    @Override
    public void execute() {
        getView2().changeSpouse();
    }
}
