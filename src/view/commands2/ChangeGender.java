package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class ChangeGender extends Command2{
    public ChangeGender(View2 view2){
        super("Change gender?", view2);
    }
    @Override
    public void execute() {
        getView2().changeGender();
    }
}
