package FT;

import FT.comparators.Comparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Tree<T extends Human> implements Serializable, Iterable<T> {  

    private List<T> members;

    private Writable writable;

    public Tree(Writable writable) {
        this.members = new ArrayList<>();
        this.writable = writable;
    }

    @Override
    public String toString() {
        StringBuilder familyMembers = new StringBuilder();
        System.out.printf("Всего людей в дереве - %d\n", members.size());
        int count = 0;
        for (T member : this) {
            familyMembers.append("Член семьи ").append(++count).append(" - ").append(member.getName()).append(", ").append("возраст ").append(member.getAge()).append("\n");
        }
        return familyMembers.toString();
    }

    public void addNewMember(T member) {
        this.members.add(member);   
        if (!(member.getFather() == null)) {
            member.getFather().addChild(member);
        }
        if (!(member.getMother() == null)) {
            member.getMother().addChild(member);
        }
        if (member.getChildren().size() > 0) {                
            member.getChildren().forEach(child -> {
                if (member.getGender().equals("M")) {
                    child.setFather(member);
                } else if (member.getGender().equals("W")) {
                    child.setMother(member);
                }
            });
        }
        System.out.printf("Добавлен новый член семьи %s\n", member.getName());
    }

    public T getByName(String name) {
        for (T human : this.members) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void saveFamilyTree() {

        writable.save(this);

    }


    public Tree readFamilyTree() {
        if (writable != null) {
            if (writable instanceof FileHandler) {
                if (writable.read() == null) {
                    System.out.println("Tree в файле нет! Создаём новое Tree.");
                    return new Tree(writable);
                } else {
                    System.out.println("Tree загружено из файла.");
                    return (Tree) writable.read();
                }
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<T>(members);
    }


    public List<T> getMembers() {
        return members;
    }

    public void sortFamilyTree(String sortParameter) {

        Collections.sort(this.getMembers(), new Comparator(sortParameter));

    }
}