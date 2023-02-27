package src.presenter;

import src.*;
import src.comparator.SortBy;
import src.ui.ConsoleForms;
import src.ui.View;

import java.io.IOException;


public class Presenter {
    private View view;
    private FamilyTree<Human> familyTree;

    public Presenter(View view, FamilyTree familyTree) {
        this.view = view;
        this.familyTree = familyTree;
        view.setPresenter(this);
    }

    public void addHuman() {
        new Stat(familyTree.maxId());
        Human h = new Human();
        h.createUnit();
        familyTree.addToFamily(h);
    }

    public boolean delHuman(int delId) {
        return familyTree.delUnit(delId);
    }

    public String findHumans(ConsoleForms form) {
        return familyTree.getString(familyTree.unPackArgsFindHumans(form.findForm()));
    }

    public String showTree(int num) {
        return familyTree.displayTree(familyTree.getUnitById(num));
    }

    public String infoHuman(int num) {
        return familyTree.getStatistics(familyTree.getUnitById(num));
    }

    public String showHumans() {
        familyTree.sort(SortBy.DATE_OF_BIRTH);
        return familyTree.getString(familyTree.getFamily());
    }

    public boolean saveTree() {
        boolean flag = true;
        try {
            familyTree.save();
        } catch (IOException e) {
            flag = false;
        }
        return flag;
    }
}
