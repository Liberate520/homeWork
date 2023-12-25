package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.FileHandler;
import model.writer.Writable;

import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;
    private boolean choice = true;
    private Writable writable;

    public Service(Writable writable) {
        familyTree = new FamilyTree();
        this.writable = writable;
    }

    public void addHuman(String name, String genderStr, LocalDate birthDate) {
        Human human;
            switch (genderStr) {
                case "Male":
                    human = new Human(name, Gender.Male, birthDate);
                    familyTree.add(human);
                    break;
                case "Female":
                    human = new Human(name, Gender.Female, birthDate);
                    familyTree.add(human);
                    break;
                default:
                    break;
        }
    } //добавление нового человека в семейное древо

    public void addWedding(int id1, int id2){ //свадьба
        familyTree.setWedding(id1, id2);
    }

    public void addDivorce(int id1, int id2){ //развод
        familyTree.setDivorce(id1, id2);
    }

    public String getTreeInfo(){
        return familyTree.toString();
    }

    public void addHumanAndParents(String name, String genderStr, LocalDate birthDate, int id1, int id2) {
        Human human;
        switch (genderStr) {
            case "Male":
                human = new Human(name, Gender.Male, birthDate, (Human) familyTree.getById(id1), (Human) familyTree.getById(id2));
                familyTree.add(human);
                break;
            case "Female":
                human = new Human(name, Gender.Female, birthDate, (Human) familyTree.getById(id1), (Human) familyTree.getById(id2));
                familyTree.add(human);
                break;
            default:
                break;
        }
    }

    public void saveTree() {
        String fileName = "src/model/writer/tree.txt";
        writable.save(familyTree, fileName);
    }

    public void loadSaveTree() {
        String fileName = "src/model/writer/tree.txt";
        familyTree = (FamilyTree) writable.load(fileName);
    }
}
