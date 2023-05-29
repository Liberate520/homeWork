package java_oop_homeWork.src.model;

import java_oop_homeWork.src.model.display.DisplayInfo;
import java_oop_homeWork.src.model.display.displayObjects.DisplayStringObject;
import java_oop_homeWork.src.model.person.Person;
import java_oop_homeWork.src.model.serialization.FileHandler;
import java_oop_homeWork.src.model.serialization.Writeble;

import java.io.Serializable;
import java.util.TreeSet;

public class Service implements Serializable {
    private int id;
    private TreeSet<FamilyTree> familyTrees;
    Writeble writeble = new FileHandler();

    private FamilyTree activeFamilyTree;

    public Service(){
        familyTrees = new TreeSet<FamilyTree>();
    }

    public void createFamilyTree(String family, String firstName, String lastName, int idSex) {
        Sex sexKinsman = null;
        for (Sex sex: Sex.values()) {
            if (idSex == sex.ordinal()) sexKinsman = sex;
        }
        Person kinsman = new Person(id++, firstName, lastName, sexKinsman);
        FamilyTree familyTree = new FamilyTree(family, kinsman);
        familyTrees.add(familyTree);
    }

    public void addParent(int idKinsman, String firstName, String lastName, int idSex) {
        Sex sexKinsman = null;
        for (Sex sex: Sex.values()) {
            if (idSex == sex.ordinal()) sexKinsman = sex;
        }
        Person parent = new Person(id++, firstName, lastName, sexKinsman);
        activeFamilyTree.addParent(idKinsman, parent);
    }

    public void addChild(int idKinsman, String firstName, String lastName, int idSex) {
        Sex sexKinsman = null;
        for (Sex sex: Sex.values()) {
            if (idSex == sex.ordinal()) sexKinsman = sex;
        }
        Person child = new Person(id++, firstName, lastName, sexKinsman);
        activeFamilyTree.addChild(idKinsman, child);
    }

    public String getFamilyTree() throws NullPointerException {
        return activeFamilyTree.familyToPrint();
    }

    public void read(String filePath) {
        FamilyTreesForWrite familyForest = (FamilyTreesForWrite) writeble.read(filePath);
        this.familyTrees = familyForest.familyTrees;
        this.id = familyForest.idLastPerson;
    }
    public void write(String filePath) {
        FamilyTreesForWrite familyForest = new FamilyTreesForWrite(familyTrees, id);
        writeble.write(familyForest, filePath);
    }

    public String getAllTrees() {
        StringBuilder sb = new StringBuilder();
        for (FamilyTree fam: familyTrees) {
            sb.append(new DisplayStringObject(new DisplayInfo(), fam.getName()).prepareForPrint());
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

    public String getActiveInfoFamily() {
        return activeFamilyTree.getInfo();
    }

    public boolean isKinsman(int id) {
       return activeFamilyTree.isKinsman(id);
    }
}
