package src;

import src.comparator.SortBy;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class Service implements Serializable {
    private FamilyTree<Human> familyTree;
    private Writable fileHandlerWritable;
    private Readable fileHandlerReadable;


    public Service() {
        familyTree = new FamilyTree<>();
    }

    private final String NOTHING = "Ничего нет";

    private FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void load(String path) throws IOException, ClassNotFoundException {
        if (fileHandlerReadable == null) {
            fileHandlerReadable = new FileRW();
        }
        Object data = fileHandlerReadable.loadFile(path);
        familyTree = (FamilyTree<Human>) data;
        new Stat(familyTree.maxId());
    }

    public void save(String path) throws IOException {
        if (fileHandlerWritable == null) {
            fileHandlerWritable = new FileRW();
        }
        fileHandlerWritable.saveFile(familyTree, path);
    }

    public void creteHuman(HashMap<String, String> personData) {
        familyTree.addToFamily(new Human(personData.get("gender"),
                personData.get("dateOfBorn"),
                personData.get("dateOfDeath"),
                personData.get("placeOfBirth"),
                personData.get("firstName"),
                personData.get("patronymic"),
                personData.get("lastName")
        ));
    }

    public boolean isFamilyTreeNotNull() {
        return familyTree != null;
    }

    public String showTree(int num) {
        if (familyTree != null) {
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

    public String findHumans(HashMap<String, String> form) {
        if (isFamilyTreeNotNull()) {
            return familyTree.getString(familyTree.findHumans(form));
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
                if (dates.datesCompare(familyTree.getUnitById(idParent).getDateOfBorn(), familyTree.getUnitById(idChild).getDateOfBorn())) {
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
