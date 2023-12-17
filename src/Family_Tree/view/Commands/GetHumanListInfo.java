package Family_Tree.view.Commands;

import Family_Tree.view.View;

public class GetHumanListInfo extends Command{

    public GetHumanListInfo(View view) {
        super("Получить список людей", view);
    }

    public void execute(){
        getView().getHumanListInfo();
    }
}
