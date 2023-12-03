package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class ChangeDeathDate extends Command2{
    public ChangeDeathDate(View2 view2){
        super("Change death date?", view2);
    }
    @Override
    public void execute() {
        getView2().changeDeathDate();
    }
}
