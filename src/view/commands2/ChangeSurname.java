package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class ChangeSurname extends Command2{
    public ChangeSurname(View2 view2){
        super("Change surname?", view2);
    }
    @Override
    public void execute() {
        getView2().changeSurname();
    }
}
