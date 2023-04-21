package model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;

import model.essences.Gender;
import model.essences.Human;
import model.essences.comparators.HumanComparatorByDateBirth;
import model.essences.comparators.HumanComparatorByFirstName;
import model.familyTree.FamilyTree;
import model.handlers.*;

public class ServiceFamilyTree {
    FamilyTree<Human> famTree;
    private final HandlerWriter hw;
    private final HandlerReader hr;

    public ServiceFamilyTree() {
        this.famTree = new FamilyTree<>();
        this.hw = new HandlerWriter();
        this.hr = new HandlerReader();
    }

    public Saveable readFromFile() {
        return hr.readFromFile();
    }

    public FamilyTree<Human> getFamilyTree() {
        return famTree;
    }

    public void sortByFirstName() {
        famTree.getCreatureList().sort(new HumanComparatorByFirstName());
    }

    public void saveToFile() {
        if (famTree.getCreatureList().size() != 0) {
            hw.saveToFile(famTree);
        } else {
            System.out.println("Дерево не содержит данных! Выгружать нечего!");
        }

    }

    // hw.saveToFile(tree);

    // public void addNewHuman() {
    // new Human("Петр", "Осетров", Gender.Male, LocalDate.of(1986, 7,
    // // 21));
    // }

    public void SortByDateBirth() {
        famTree.getCreatureList().sort((Comparator<? super Human>) new HumanComparatorByDateBirth());
    }

    public void addFamily(Human creature) {
        famTree.addHuman(creature);
        for (Human parent : creature.getParents()) {
            famTree.addHuman(parent);
        }

        for (Human child : creature.getChildren()) {
            famTree.addHuman(child);
        }
    }

    public String viewFamily() {
        StringBuilder family = new StringBuilder();
        for (Human human : famTree.getCreatureList()) {
            family.append(human.getInfo());
        }
        return family.toString();

    }

    public boolean addCreature(String firstName, String lastName, Gender gender, LocalDate dateBirth) {
        return famTree.addHuman(new Human(firstName, lastName, gender, dateBirth));
    }

    public boolean validForChild(String childFirstName, String childLastName, String parentFirstName,
            String parentLastName) {
        famTree.validForChild(childFirstName, childLastName, parentFirstName, parentLastName);
        return false;
    }

    public boolean readFamilyFromFile() {
        try {
            famTree = (FamilyTree<Human>) hr.readFromFile();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean writeFamilyToFile() {
        Human dad = new Human("Dmitry", "Rudakov", Gender.Male, LocalDate.of(1986, 7, 21));
        Human mom = new Human("Anastasiya", "Savina", Gender.Female, LocalDate.of(1988, 2, 1));
        Human son = new Human("Dmitry", "Savin", Gender.Male, LocalDate.of(2000, 5, 4));
        Human dah = new Human("Olesya", "Osetrova", Gender.Female, LocalDate.of(2005, 11, 27));

        dad.addChild(son);
        dad.addChild(dah);
        mom.addChild(son);
        mom.addChild(dah);

        famTree.addHuman(dad);
        famTree.addHuman(mom);
        famTree.addHuman(son);
        famTree.addHuman(dah);
        // boolean answer = hw.saveToFile(famTree);
        if (famTree.getCreatureList().size() != 0)
            return hw.saveToFile(famTree);
        else
            return false;
    }

    public String viewInfoByNames(String firstName, String lastName) {
        Human human = famTree.getHumanByNames(firstName, lastName);
        HashSet<Human> relatives = famTree.getRelatives(human);
        StringBuilder answer = new StringBuilder();
        for (Human relative : relatives) {
            answer.append(relative.getInfo());
        }
        return answer.toString();
    }

}