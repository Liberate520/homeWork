package homeWork.model.service;

import java.time.LocalDate;
import homeWork.model.FamilyTree.FamilyTree;
import homeWork.model.fileHandler.Writable;
import homeWork.model.human.Human;
import homeWork.model.human.gender.Gender;

public class Service {
    private int id;
    private FamilyTree<Human> familyTree;
    Writable wr;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate birthdate, int age, int id) {
        Human human = new Human(name, gender, birthdate, age, id++);
        familyTree.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(familyTree.size());
        sb.append(" объектов: \n ");
        for (Human human : familyTree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void saveInFile() {
        wr.save(familyTree, "/Users/xenia_golb/Desktop/familyTree/homeWork");
    }

    public void addChild(String name, int age) {
        Human human = new Human(name, null, null, age, id);
        familyTree.addHuman(human);
    }

    public void addParent(String name, int age) {
        Human human = new Human(name, null, null, age, id);
        familyTree.addHuman(human);
    }

    public void readFromFile() {
        FamilyTree familyTree = (FamilyTree) wr.read("/Users/xenia_golb/Desktop/familyTree/homeWork");

    }
}