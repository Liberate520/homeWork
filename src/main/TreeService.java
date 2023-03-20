package main;

public class TreeService implements Service {
    private final Writable fileHandler;
    private FamilyTree<Human> familyTree;

    public void load() {
        familyTree = (FamilyTree<Human>) fileHandler.read();
    }

    public TreeService() {
        this.fileHandler = new FileHandler("main.FamilyTree.out");
        familyTree = new FamilyTree<>();
    }

    public String printTree() {
        return familyTree.getInfo();
    }

    public void save() {
        fileHandler.write(familyTree);
    }

    @Override
    public String findHuman(String lastname, String firstname) {
        return familyTree.getByName(lastname, firstname).getInfo();
    }

    @Override
    public boolean addNewHuman(String lastname, String firstname, String patronymic, String gender, String fatherName, String motherName) {
        GenderType enumGender;
        if (gender.equalsIgnoreCase("м")) {
            enumGender = GenderType.Male;
        } else {
            enumGender = GenderType.Female;
        }
        Human father = familyTree.getByName(lastname, fatherName);
        Human mother = familyTree.getByName(lastname, motherName);
        Human child = new Human(lastname, firstname, patronymic, enumGender, father, mother);
        return familyTree.add(child);
    }
}