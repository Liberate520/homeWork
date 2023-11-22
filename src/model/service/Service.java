package model.service;

import model.human.Gender;
import model.human.Human;
import model.group.FamilyTree;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }

    public void addHuman(int human_Id, int parent_Id, String name, LocalDate birthday, Gender gender, String second_parent) {
        Human human = new Human(human_Id, parent_Id, name, birthday, gender, second_parent);
        tree.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список :\n");
        for (Human k : tree) {
            stringBuilder.append(k);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }
}