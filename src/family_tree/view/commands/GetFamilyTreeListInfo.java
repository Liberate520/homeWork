package family_tree.view.commands;

import family_tree.view.View;

public class GetFamilyTreeListInfo extends Command{

    public GetFamilyTreeListInfo(View view)
    {
        super("Получить информацию о дереве", view);
    }
    public void execute()
    {
        getView().getFamilyTreeInfo();
    }
}