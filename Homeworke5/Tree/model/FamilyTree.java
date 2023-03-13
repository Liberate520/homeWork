package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.comparator.HumanComparatorByDate;
import model.comparator.HumanComparatorByName;

public class FamilyTree implements Serializable, Iterable<Human>{
    private Writable writable;
    private List<Human> humanList;
    private Scanner scan = new Scanner(System.in);

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public List<Human> getHumanList() {
        return humanList;
    }
    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public Writable getWritable() {
        return writable;
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public boolean add(Human human) {
        if (human == null) return false;
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getMother() != null) human.getMother().addChild(human);
            if (human.getFather() != null) human.getFather().addChild(human);
            return true;
        }
        return false;
    }

    public Human getByName(String name) {
        for (Human human : humanList) {
            if (human.getFullName().equals(name))
                return human;
        }
        return null;
    }

    @Override
    public String toString() {
        String list = "";
        for (Human human : humanList)
            list += human.toString();
        return list;
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByDate());
    }

    
    public void searchByName() {
        System.out.println("Обращаем ваше внимание что ввод должен быть на латиннице.");
        String name = scan.next();
        for (Human human : humanList) {
            if (human.getFullName().contains(name)) {
                System.out.println(human);
            }
        }
    }

    public Human addNewHuman() {
        System.out.print("Ввод новых должен осуществляться по старшенству.\n"
                       + "Введите имя и фамилию на латиннице: ");
        String fullName = scan.next();
        System.out.print("Введите год рождения: ");
        int birth = scan.nextInt();
        System.out.print("Если родители неизвестны то поля необходимо оставить пустыми.\n"
                       + "Введите имя и фамилию матери на латиннице: ");
        String mom = scan.next();
        System.out.print("Введите имя и фамилию отца на латиннице: ");
        String papa = scan.next();
        return new Human(fullName, birth, getByName(mom), getByName(papa));
    }
}