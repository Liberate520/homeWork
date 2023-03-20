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
        int id = cmdGet.getId() - 1;
        String name = cmdGet.getName();
        view.setPrintOut(familyTree.getStringMembers(sortMode, id, name));
    }

    private void cmdAddHandler(ICmdAdd cmdAdd) {
        String name = cmdAdd.getName();
        String sex = cmdAdd.getSex();
        Date birthDay = cmdAdd.getBirthDay();
        var parents = new FamilyTreeMemeber[] {familyTree.getMemeberById(cmdAdd.getParents()[0] - 1), familyTree.getMemeberById(cmdAdd.getParents()[1] - 1)};
        familyTree.addMember(new FamilyTreeMemeber(name, sex, birthDay, parents));
    }
}
