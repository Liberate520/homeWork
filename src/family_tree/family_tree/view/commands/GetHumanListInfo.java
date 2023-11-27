package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public class GetHumanListInfo extends Command {

    public GetHumanListInfo(View view) {
        super("Получить список Human", view);
    }

    public void execute(){
        getView().getHumanListInfo();
    }

}
