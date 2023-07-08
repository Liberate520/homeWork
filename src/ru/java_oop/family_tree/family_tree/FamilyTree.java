package ru.java_oop.family_tree.family_tree;

import ru.java_oop.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humanId;
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public boolean addFamilyMember(Human human) {
        if (human == null) {
            return false;
        }
        if (!this.humanList.contains(human)) {
            this.humanList.add(human);
            human.setId(humanId++);
            this.addToParents(human);
            this.addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<Human> getByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human h : this.humanList) {
            if (h.getName().equalsIgnoreCase(name)) {
                result.add(h);
            }
        }
        return result;
    }

    public Human getById(long id) {
        for (Human h : this.humanList) {
            if (h.getId() == id) {
                return h;
            }
        }

        return null;
    }

    private boolean checkId(long id) {
        if (id >= humanId || id < 0) {
            return false;
        }
        for (Human h : this.humanList) {
            if (h.getId() == id) {
                return true;
            }
        }
        return false;

    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean divorce(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            if (human1.getSpouse() == human2 && human2.getSpouse() == human1) {
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family tree contains ").append(this.humanList.size()).append(" objects\n");
        for (Human human : this.humanList){
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}
