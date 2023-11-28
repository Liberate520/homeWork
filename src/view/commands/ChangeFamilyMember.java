package homeWork.src.view.commands;

import homeWork.src.view.View;

public class ChangeFamilyMember extends Command {

    public ChangeFamilyMember(View view){
        super("Change family member", view);
    }
    public void execute() {
        getView().changeFamilyMember();
    }
}
