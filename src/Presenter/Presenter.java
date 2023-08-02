package Presenter;

import Model.FamilyTree.FamilyTree.FamilyTree;
import Model.FileHandler.HandleFile;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Human.Status;
import View.View;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Presenter implements Serializable {
    private View view;
    private FamilyTree familyTree;
    private String filePath = "src/Model/date/fileText.txt";
    private HandleFile handleFile;

    public Presenter(View view) {
        this.view = view;
        familyTree = new FamilyTree<>();
        try {
            handleFile = new HandleFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addHuman(String name, LocalDate date, Gender gender, Status status, LocalDate deathDate) {
        Human human = new Human(name, date, gender, status);
        human.setDeathDate(deathDate);
        familyTree.addToList(human);
    }

    public void getInfo() {
        view.printAnswer(familyTree.getInfoFamilyTree());
    }

    public void sortByName() {
        familyTree.sortByName();
        getInfo();
    }

    public void sortByAge() {
        familyTree.sortByAge();
        getInfo();
    }

    public void findById(int count) {
        if(familyTree.findById(count) == null){
            view.printAnswer(view.error());
        } else {
            view.printAnswer(familyTree.findById(count).getInfo());
        }
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
            view.printAnswer(view.error());
        } else {
            familyTree.makeMarriage(spouseOne, spouseTwo);
        }
    }

    public void addChild() {
    }

    public void saveInfo() {
        handleFile.writeToFile(familyTree, filePath);
    }

    public void loadInfo(){
        familyTree = (FamilyTree<Human>) handleFile.readFromFile(filePath);
        familyTree.getInfoFamilyTree();
    }
}
