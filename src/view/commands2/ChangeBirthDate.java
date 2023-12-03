package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class ChangeBirthDate extends Command2{
    public ChangeBirthDate(View2 view2){
        super("Change birth date?", view2);
    }
    @Override
    public void execute() {
        getView2().changeBirthDate();
    }
}
