package homeWork.model.service;

import java.io.Serializable;
import java.time.LocalDate;

import homeWork.model.FamilyTree.FamilyTree;
import homeWork.model.human.Human;
import homeWork.model.human.gender.Gender;

public class Service implements Serializable {
    private long id;
    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate ofLocalDate, int age, int id) {
        Human human = new Human(name, gender, ofLocalDate, age, id++);
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

    public void addHuman(String name, int age) {
        Human human = new Human(name, age);
        familyTree.addHuman(human);
    }
}