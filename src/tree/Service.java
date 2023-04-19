package tree;

import tree.person.Person;

public class Service {
    private FamilyTree<Person> familyTree;

    private Writable fileHandler;

    public Service() {
        familyTree = new FamilyTree();
        fileHandler = new FileHandler();

    }

    public boolean addMember(String name, String FatherName, String MatherName) {
        Person newPerson = new Person(name, familyTree.find(FatherName), familyTree.find(MatherName));
        return familyTree.addMember(newPerson);
    }

    public String getInfo() {
        return familyTree.getInfo();
    }

    public Person find(String name) {
        return familyTree.find(name);
    }

    public String getChildren(String nameFather) {
        if (familyTree.find(nameFather) != null) {
            return familyTree.find(nameFather).getChildrenInfo();
        } else
            return "Родитель не найден";
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByChild() {
        familyTree.sortByChild();
    }

    public boolean editName(String name, String newName) {
        if (familyTree.find(name) != null) {
            familyTree.find(name).setName(newName);
            return true;
        }
        return false;
    }

    public boolean editYearBirth(String name, int yearBirth) {
        if (familyTree.find(name) != null) {
            familyTree.find(name).setYearBirth(yearBirth);
            return true;
        }
        return false;
    }

    public boolean editYearDeath(String name, int yearDeath) {
        if (familyTree.find(name) != null) {
            familyTree.find(name).setYearDeath(yearDeath);
            return true;
        }
        return false;
    }

    public boolean save(String fileName) {
        return fileHandler.save(familyTree, fileName);
    }

    public boolean load(String fileName) {
        familyTree = (FamilyTree) fileHandler.load(fileName);
        if (familyTree != null) {
            return true;
        }
        return false;
    }

}
