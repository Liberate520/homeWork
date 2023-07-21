package Model.service;

import java.time.LocalDate;

import Model.familyTree.FamilyTree;
import Model.fileHandlers.Writable;
import Model.human.Gender;
import Model.human.Human;

public class Service {
    private FamilyTree<Human> familyTree;
    private Writable writable;

    public Service(Writable writable) {
        familyTree = new FamilyTree<>();
        this.writable = writable;
    }

    public boolean addItem(String name, String[] birthDateArray, String genderString) {
        LocalDate birthDate = LocalDate.of(Integer.parseInt(birthDateArray[2]), Integer.parseInt(birthDateArray[1]),
                Integer.parseInt(birthDateArray[0]));
        Gender gender = Gender.Male;
        if (genderString.equals("Female")) {
            gender = Gender.Female;
        }
        Human human = new Human(name, birthDate, gender);
        if (familyTree.addItem(human)) {
            return true;
        }
        return false;
    }

    public boolean setDeathDate(String nameHuman, String[] deathDateArray) {
        Human human = findItem(nameHuman);
        LocalDate deathDate = LocalDate.of(Integer.parseInt(deathDateArray[2]), Integer.parseInt(deathDateArray[1]),
                Integer.parseInt(deathDateArray[0]));
        if (human.setDeathDate(deathDate)) {
            return true;
        }
        return false;
    }

    public boolean createRelatings(String nameParent1, String nameParent2, String nameChild) {
        Human parent1 = findItem(nameParent1);
        Human parent2 = findItem(nameParent2);
        Human child = findItem(nameChild);
        if (child.createRelatings(parent1, parent2, child)) {
            return true;
        }
        return false;
    }

    public boolean addChildren(String nameParent, String nameChild) {
        Human parent = findItem(nameParent);
        Human child = findItem(nameChild);
        if (parent.addChildren(child)) {
            return true;
        }
        return false;
    }

    public boolean addParents(String nameChild, String nameParent1, String nameParent2) {
        Human child = findItem(nameChild);
        Human parent1 = findItem(nameParent1);
        Human parent2 = findItem(nameParent2);
        if (child.addParents(parent1, parent2)) {
            return true;
        }
        return false;
    }

    public Human findItem(String name) {
        if (familyTree.getByName(name) != null) {
            return familyTree.getByName(name);
        }
        return null;
    }

    public boolean checkItem(String name) {
        if (familyTree.getByName(name) != null) {
            return true;
        }
        return false;
    }

    public boolean deleteItem(String nameHuman) {
        Human human = findItem(nameHuman);
        if (familyTree.deleteItem(human)) {
            return true;
        }
        return false;
    }

    public String sortByName() {
        familyTree.sortByName();
        return familyTree.getFamilyTree();
    }

    public String sortByBirthDate() {
        familyTree.sortByBirthDate();
        return familyTree.getFamilyTree();
    }

    public String sortByAge() {
        familyTree.sortByAge();
        return familyTree.getFamilyTree();
    }

    public String getFamilyTree() {
        return familyTree.getFamilyTree();
    }

    public boolean saveTree(String filePath) {
        if (writable.save(this.familyTree, filePath)) {
            return true;
        }
        return false;
    }

    public boolean loadTree(String filePath) {
        this.familyTree = (FamilyTree<Human>) writable.read(filePath);
        if (this.familyTree != null) {
            return true;
        }
        return false;
    }
}
