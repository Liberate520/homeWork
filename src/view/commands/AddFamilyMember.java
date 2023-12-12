package homeWork.src.view.commands;

import homeWork.src.view.View;

public class AddFamilyMember extends Command{

    public AddFamilyMember(View view) {
        super("Add family member", view);
    }

    public void execute(){
        getView().addFamilyMember();
    }
}
