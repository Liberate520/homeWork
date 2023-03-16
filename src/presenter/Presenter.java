package presenter;

import java.util.Date;
import cmdui.IView;
import cmdui.commands.ICmdAdd;
import cmdui.commands.ICmdGet;
import familytree.FamilyTree;
import familytree.FamilyTreeMemeber;
import familytree.SortMode;

public class Presenter {
    private IView view;
    private FamilyTree<FamilyTreeMemeber> familyTree;

    public Presenter(IView view, FamilyTree<FamilyTreeMemeber> familyTree) {
        this.view = view;
        this.familyTree = familyTree;
        setCmdHandlers();
    }

    private void setCmdHandlers() {
        view.setCmdGetHandler(this::cmdGetHandler);
        view.setCmdAddHandler(this::cmdAddHandler);
    }
    
    private void cmdGetHandler(ICmdGet cmdGet) {
        SortMode sortMode = cmdGet.getSortMode();
        switch (sortMode) {
            case name:
                familyTree.setSortMode(SortMode.name);
                break;
            case birthDay:
                familyTree.setSortMode(SortMode.birthDay);
                break;
            case noSort:
                familyTree.setSortMode(SortMode.noSort);
                break;
        }
        int id = cmdGet.getId() - 1;
        String name = cmdGet.getName();
        if(id >= 0)
            view.setPrintOut(familyTree.getMemeberById(id).toString());
        else if(name != null)
            view.setPrintOut(familyTree.toString());
        else
            view.setPrintOut(familyTree.toString());
    }

    private void cmdAddHandler(ICmdAdd cmdAdd) {
        String name = cmdAdd.getName();
        String sex = cmdAdd.getSex();
        Date birthDay = cmdAdd.getBirthDay();
        var parents = new int[] {cmdAdd.getParents()[0] - 1, cmdAdd.getParents()[1] - 1};
        familyTree.addChild(name, sex, birthDay, parents);
    }
}
