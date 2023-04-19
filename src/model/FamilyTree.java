package model;

import model.comparators.HumanComparatorByBirthday;
import model.comparators.HumanComparatorById;
import model.comparators.HumanComparatorByName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<H extends Human> implements Serializable, FamilyTreeIterator<H> {
    private int id;
    private List<H> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<H>();
    }

    List<H> getFamilyTree() {
        return familyTree;
    }

    void sortByParameter(int sortNumber) {
        switch (sortNumber) {
            case 1:
                sortByName();
                System.out.println("Генеалогическое древо отсортировано по имени");
                break;
            case 2:
                System.out.println("Генеалогическое древо отсортировано по году рождения");
                sortByBirthYear();
                break;
            case 3:
                System.out.println("Генеалогическое древо отсортировано по Id");
                sortById();
                break;
            default:
                System.out.println("Вы ввели некорректный номер сортировки!");
        }
    }

    void addHuman(H human) {
        familyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChild(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChild(human);
        }
    }

    Human getHumanById(int id) {
        for (Human human : familyTree) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    int getLastId() {
        if (familyTree == null){
            return -1;
        }
        return familyTree.size() - 1;
    }

    Human getHumanByName(String name) {
        String nameFull = name.replace(",", " ");
        for (Human human : familyTree) {
            if (human.getFullName().equals(nameFull)) {
                return human;
            }
        }
        return null;
    }

    Gender getGender(String gender) {
        if (gender.equals("м")) {
            return Gender.male;
        } else if (gender.equals("ж")){
            return Gender.female;
        }
        return null;
    }

    void sortByName() {
        familyTree.sort(new HumanComparatorByName());
    }

    void sortByBirthYear() {
        familyTree.sort(new HumanComparatorByBirthday());
    }

    void sortById() {
        familyTree.sort(new HumanComparatorById());
    }

    @Override
    public boolean hasNext() {
        return this.id < familyTree.size();
    }

    @Override
    public H next() {
        return this.familyTree.get(id++);
    }
}