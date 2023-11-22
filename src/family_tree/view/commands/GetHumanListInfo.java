package family_tree.view.commands;

import family_tree.view.View;

public class GetHumanListInfo extends Commands {

    public GetHumanListInfo(View view) {
        super("Получить список членов", view);
    }

    public void execute() {
        getView().GetHumanListInfo();
    }
}
