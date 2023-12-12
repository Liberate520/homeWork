package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class ChangeMother extends Command2{
    public ChangeMother(View2 view2){
        super("Change mother?", view2);
    }
    @Override
    public void execute() {
        getView2().changeMother();
    }
}
