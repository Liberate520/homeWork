package famalyTree;

import humans.*;
import humans.comparators.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyMembers;

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public List<Human> getFamilyMembers() {
        return familyMembers;
    }

    public void addMember(Human human) {
        familyMembers.add(human);
    }

    /**
     * Метод добавляет в партнеры одного объекта другого.
     * Если пол объекта женский, то фамилия объекта меняется на фамилию партнера с добавлением буквы "а"
     * Также если семейное дерево не содержит какойто из объектов, то добавляет его
     */
    public void getMarried(String human1Name, String human2Name) {
        Human human1 = this.searchByName(human1Name);
        Human human2 = this.searchByName(human2Name);
        human1.setPartner(human2);
        human2.setPartner(human1);
        if (human1.getGender().equals(Gender.Female)) {
            human1.setLastName(human2.getLastName() + "а");
        } else {
            human2.setLastName(human1.getLastName() + "а");
        }
        if (!familyMembers.contains(human1)) {
            familyMembers.add(human1);
        }
        if (!familyMembers.contains(human2)) {
            familyMembers.add(human2);
        }
    }

    /**
     * Метод, в зависимости от пола указанного родителя и самого ребенка, меняет фамилию ребенка,
     * добавляет родителей в объект ребенка.
     * Также добавляет ребенка в семейное дерево и в список детей обоих родителей
     */
    public void addChild(String parentFirstName, Gender gender, String firstName) {
        Human parent = this.searchByName(parentFirstName);
        Human child = new Human(gender, firstName);
        if (child.getGender().equals(Gender.Female)) {
            if (parent.getGender().equals(Gender.Female)) {
                child.setLastName(parent.getLastName());
            } else {
                child.setLastName(parent.getPartner().getLastName());
            }
        } else {
            if (parent.getGender().equals(Gender.Female)) {
                child.setLastName(parent.getPartner().getLastName());
            } else {
                child.setLastName(parent.getLastName());
            }
        }
        if (parent.getGender().equals(Gender.Female)) {
            child.setMother(parent);
            child.setFather(parent.getPartner());
        } else {
            child.setFather(parent);
            child.setMother(parent.getPartner());
        }
        this.addMember(child);
        parent.addChild(child);
        parent.getPartner().addChild(child);
    }

    /**
     * Возвращаются в виде строки имена родителей объекта
     */
    public String getParents(String name) {
        Human human = this.searchByName(name);
        return "Мама: " + human.getMother().getFirstName() + "\n" +
                "Папа: " + human.getFather().getFirstName();
    }

    /**
     * Выводятся имена сестер и братьев объекта
     */
    public List<Human> getBrothersAndSisters(String name) {
        Human human = this.searchByName(name);
        List<Human> bros = new ArrayList<>();
        for (Human broAndSis :
                human.getFather().getChildren()) {
            if (!broAndSis.equals(human)) {
                bros.add(broAndSis);
            }
        }
        return bros;
    }

    /**
     * Возвращается имя и фамилия партнера объекта
     */
    public String getPartner(String name) {
        Human human = this.searchByName(name);
        String role;
        if (human.getGender().equals(Gender.Female)) {
            role = "Муж: ";
        } else {
            role = "Жена: ";
        }
        return role + human.getPartner().getLastName() + " " + human.getPartner().getFirstName();

    }

    /**
     * Возвращается строка со всей информацией о всех объектах семейного дерева
     */
    public void getInfo() {
        for (Human human : familyMembers) {
            System.out.println(human);
        }
    }

    public Human searchByName(String firstName) {
        for (Human human : familyMembers) {
            if (human.getFirstName().equals(firstName)) {
                return human;
            }
        }
        return null;
    }
    public void sortByName(){
        familyMembers.sort(new HumanComparatorByName());
    }

    public void sortAmountOfChildren(){
        familyMembers.sort(new HumanComparatorByChildren());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyMembers);
    }
}
