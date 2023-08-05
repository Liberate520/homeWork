package Model.FamilyTree;


import Model.FamilyTree.FamilyTree.EntityItem;
import Model.FamilyTree.FamilyTree.FamilyTree;
import Model.FileHandler.HandleFile;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Human.Status;
import View.TextInput;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;
    private int id;
    private HandleFile handleFile;
    private String filePath = "src/Model/date/fileText.txt";
    private TextInput textInput;


    public Service() {
        familyTree = new FamilyTree<>();
        textInput = new TextInput();
        try {
            handleFile = new HandleFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        id = 0;
    }

    public void addHuman(String name, LocalDate date, Gender gender, Status status, LocalDate deathDate) {
        Human human = new Human(name, date, gender, status);
        human.setDeathDate(deathDate);
        familyTree.addToList(human);
        id++;
    }

    public void addHumanWithParents(String name, LocalDate date, Gender gender, Status status, int fatherId,
                                    int motherId, LocalDate deathDate) {
        Human father = (Human) familyTree.findById(fatherId);
        Human mother = (Human) familyTree.findById(motherId);
        familyTree.addToList(new Human(name, date, gender, status, father, mother));
        int humanId = familyTree.getSize() - 1;
        familyTree.findById(humanId).setDeathDate(deathDate);
    }

    public void makeMarriage(int spouseOneId, int spouseTwoId) {
        Human spouseOne = (Human) familyTree.findById(spouseOneId);
        Human spouseTwo = (Human) familyTree.findById(spouseTwoId);
        if (spouseTwo == null || spouseOne == null) {
            textInput.printAnswer("error");
        } else {
            familyTree.makeMarriage(spouseOne, spouseTwo);
        }
    }

    public void findById(int id) {
        Human human = (Human) familyTree.findById(id);
        if (human == null) {
            textInput.printAnswer("errorSetId");
        } else {
            textInput.printInfo(human.getInfo());
        }
    }

    public void saveInfo() {
        handleFile.writeToFile(familyTree, filePath);
    }

    public void loadInfo() {
        familyTree = handleFile.readFromFile(filePath);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void getInfoFamilyTree() {
        String information = familyTree.getInfoFamilyTree();
        if (information == null) {
            textInput.printAnswer("noPeople");
        } else {
            textInput.printInfo(information);
        }
    }

    public void addChildToParents(int childId, int motherId, int fatherId) {
        Human child = (Human) familyTree.findById(childId);
        Human mother = (Human) familyTree.findById(motherId);
        Human father = (Human) familyTree.findById(fatherId);
        if (child == null) {
            textInput.printAnswer("errorSetChild");
        } else if ((mother == null) || (father == null)) {
            textInput.printAnswer("errorParentsToChild");
        } else {
            child.addParents(father, mother);
            father.setChild(child);
            mother.setChild(child);
        }
    }
}
