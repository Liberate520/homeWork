package FamilyTree.FamilyTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import FamilyTree.Human.Gender;
import FamilyTree.Human.Human;
import FamilyTree.Writable.FileHandler;
import FamilyTree.Writable.Writable;


public class FamilyTree implements Serializable {
    String name;
    List<Human> familyList = new ArrayList<>();

    public FamilyTree(String name) throws IOException {
        this.name = name;
    }

    public void getAllChild(Human human) {
        System.out.println(human.getName() + " является родителем: ");
        for (Human kid : human.getChildList()) {
            System.out.println(kid.info());
        }
        System.out.println();
    }

    public void getParentsInfo(Human human) {
        System.out.println("Родители " + human.getName() + ":");
        System.out.println(human.getFather().info() + " " + human.getMother().info());
        System.out.println();
    }

    public void addHuman(Human human) {
        familyList.add(human);
        if (human.getFather() != null && human.getMother() != null) {
            addChild(human.getFather(), human.getMother(), human);
        }
        System.out.println(human.getName()+" добавлен\n");
    }

    public void addChild(Human human, Human partner, Human child) {
        human.getChildList().add(child);
        partner.getChildList().add(child);
        if (human.getGender() == Gender.MALE) {
            child.setFather(human);
            child.setMother(partner);
        } else {
            child.setFather(partner);
            child.setMother(human);
        }
    }

    public Human getByName(String name) {
        for (Human human : familyList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        System.out.println(name + " - не найден\n");
        return null;
    }

    public void humanDie(Human human, String date) {
        System.out.println(human.getName() + " - покинул этот мир\n");
        human.setDateOfDeath(date);

    }

    public void save(String pathName) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(this, pathName);
    }

    public FamilyTree load(String pathName) throws IOException, ClassNotFoundException {
        Writable writable = new FileHandler();
        FamilyTree tree = (FamilyTree) writable.load(pathName);
        return tree;
    }
}
