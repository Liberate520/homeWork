package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public class ChangePatronymicName extends Command2{
    public ChangePatronymicName(View2 view2){
        super("Change patronymic name?", view2);
    }
    @Override
    public void execute() {
        getView2().changePatronymicName();
    }
}
