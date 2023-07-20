package homeWork.service;

import java.io.Serializable;
import homeWork.FamilyTree.FamilyTree;
import homeWork.human.Human;

public class Service implements Serializable {
    private long id;
    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(int id, String name, int age) {
        Human human = new Human(id++, name, age);
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
}