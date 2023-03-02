package src;

import src.comparator.SortBy;
import src.ui.ConsoleForms;

import java.io.IOException;

public class Services {
    private FamilyTree<Human> familyTree;


    public Services(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public Services() {
        familyTree = new FamilyTree<>();
    }

    private final String NOTHING = "Ничего нет";

    private FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void load(String path) throws IOException, ClassNotFoundException {
        familyTree.load(path);
    }

    public void save(String path) throws IOException {
        familyTree.save(path);
    }

    public void creteHuman() {
        HumanFactory humanFactory = new HumanFactory();
        new Stat(familyTree.maxId());
        if (familyTree == null) {
            familyTree = new FamilyTree<>();
        }
        familyTree.addToFamily(humanFactory.creteHuman());
    }

    public boolean isFamilyTreeNotNull() {
        boolean flag = true;
        try {
            familyTree.size();
        } catch (Exception e) {
            flag = false;
            familyTree = new FamilyTree<>();
        }
        return flag;
    }

    public String showTree(int num) {
        if (isFamilyTreeNotNull()) {
            return familyTree.displayTree(familyTree.getUnitById(num));
        } else {
            return NOTHING;
        }
    }

    public String showHumans() {
        if (isFamilyTreeNotNull()) {
            familyTree.sort(SortBy.DATE_OF_BIRTH);
            return familyTree.getString(familyTree.getFamily());
        }
        return NOTHING;
    }

    public boolean delUnit(int delId) {
        return familyTree.delUnit(delId);
    }

    public String findHumans(ConsoleForms form) {
        if (isFamilyTreeNotNull()) {
            return familyTree.getString(familyTree.findHumans(form.findForm()));
        } else {
            return NOTHING;
        }
    }

    public String infoHuman(int num) {
        if (isFamilyTreeNotNull()) {
            return familyTree.getStatistics(familyTree.getUnitById(num));
        } else {
            return NOTHING;
        }
    }

    public boolean addChild(int idChild, int idParent) {
        Dates dates = new Dates();
        if (isFamilyTreeNotNull() && idChild != idParent) {
            if (familyTree.getUnitById(idParent) == null || familyTree.getUnitById(idChild) == null) {
                return false;
            } else {
                if(dates.datesCompare(familyTree.getUnitById(idParent).getDateOfBorn(), familyTree.getUnitById(idChild).getDateOfBorn())) {
                    familyTree.getUnitById(idParent).addChild(familyTree.getUnitById(idChild));
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
