package model;

import model.humans.Gender;
import model.humans.Human;
import model.humans.tree.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Service {
    private int id;
    private FamilyTree<Human> familyTree;
    private List<FamilyTree> familyTreeList;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(familyTree);
    }

    public Service() {
        this(new FamilyTree());
        addHuman("Дмитрий", "Бохан", Gender.Male, "12.11.1990");
        addHuman("Ирина", "Бохан", Gender.Female, "31.10.1965");
        addHuman("Анна", "Новикова", Gender.Female, "23.10.1988");
        addHuman("Павлина", "Мищенко", Gender.Female, "13.03.1934");
    }

    public void addHuman(String firstName, String lastName, Gender gender, String dateOfBirth) {
        familyTree.addHumanOfFamilyTree(new Human(id++, firstName, lastName, gender, dateOfBirth));
    }

    public void addHumanList(FamilyTree familyTree) {
        familyTreeList.add(familyTree);
    }


    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : familyTree) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public String searchByName(String find) {
        for (Human human : familyTree) {
            if (human.getFirstName().equals(find)) {
                return human.toString();
            }
        }
        return "Не найдено\n";
    }

    public String listOfNames() {
        return familyTree.listOfNames();
    }

    public Human searchByID(int find) {
        for (Human human : familyTree) {
            if (human.getId() == find) {
                return human;
            }
        }
        return null;
    }

    public Set<Human> birthdaySort() {
        return familyTree.birthdaySort();
    }

    public Set<Human> firstNameSort() {
        return familyTree.firstNameSort();
    }

    public void printFamilySet(Set<Human> humanSet) {
        familyTree.printFamilySet(humanSet);
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }
}
