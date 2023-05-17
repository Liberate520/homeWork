package java_oop_homeWork.src.model;

import java_oop_homeWork.src.model.familyTree.FamilyTree;
import java_oop_homeWork.src.model.human.Human;
import java_oop_homeWork.src.model.serialization.FileHandler;
import java_oop_homeWork.src.model.serialization.Writeble;

import java.io.Serializable;
import java.util.TreeSet;

public class Service implements Serializable {
    public String filePath = "FamilyTrees";
    private int id;
    private TreeSet<FamilyTree> familyTrees;
    Writeble writeble = new FileHandler();

    private FamilyTree activeFamilyTree;

    public void createFamilyTree(String family, String firstName, String lastName, int idSex) {
        Sex sexKinsman = null;
        for (Sex sex: Sex.values()) {
            if (idSex == sex.ordinal()) sexKinsman = sex;
        }
        FamilyTreeItem kinsman = new Human(id++, firstName, lastName, sexKinsman);
        FamilyTree familyTree = new FamilyTree<FamilyTreeItem>(family, kinsman);
        familyTrees.add(familyTree);
    }

    public void addParent(int idKinsman, String firstName, String lastName, int idSex) {
        Sex sexKinsman = null;
        for (Sex sex: Sex.values()) {
            if (idSex == sex.ordinal()) sexKinsman = sex;
        }
        FamilyTreeItem parent = new Human(id++, firstName, lastName, sexKinsman);
        activeFamilyTree.addParent(idKinsman, parent);
    }

    public void addChild(int idKinsman, String firstName, String lastName, int idSex) {
        Sex sexKinsman = null;
        for (Sex sex: Sex.values()) {
            if (idSex == sex.ordinal()) sexKinsman = sex;
        }
        FamilyTreeItem child = new Human(id++, firstName, lastName, sexKinsman);
        activeFamilyTree.addChild(idKinsman, child);
    }

    public String getFamilyTree() throws NullPointerException {
        return activeFamilyTree.familyToPrint();
    }

    public Service() {
        familyTrees = new TreeSet<FamilyTree>();
    }

    public void read() {
        this.familyTrees = ((FamilyTrees) writeble.read(filePath)).familyTrees;
        this.id = ((FamilyTrees) writeble.read(filePath)).id;
    }
    public void write() {
        FamilyTrees familyForest = new FamilyTrees(familyTrees, id);
        writeble.write(familyForest, filePath);
    }

    public String getAllTrees() {
        StringBuilder sb = new StringBuilder();
        for (FamilyTree fam: familyTrees) {
            sb.append(fam.getName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void selectFamilyTree(String family) throws NullPointerException {
        for (FamilyTree fam: familyTrees) {
            if (fam.getName().equals(family)) {
                activeFamilyTree = fam;
            }
        }
    }

    public String getActiveNameFamily() {
        return activeFamilyTree.getName();
    }

    public boolean isKinsman(int id) {
       return activeFamilyTree.isKinsman(id);
    }
}
