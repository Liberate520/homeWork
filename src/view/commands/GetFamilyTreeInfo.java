package homeWork.src.view.commands;

import homeWork.src.view.View;

public class GetFamilyTreeInfo extends Command{

    public GetFamilyTreeInfo(View view) {
        super("Get family tree info", view);
    }

    public void execute(){
        getView().getFamilyTreeInfo();
    }
}