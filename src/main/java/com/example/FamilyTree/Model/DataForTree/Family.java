package com.example.FamilyTree.Model.DataForTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Family<T extends FamilyInterface> implements Serializable, FamilyInterface {
    private T object;
    private List<T> parents;
    private List<T> children;

    public Family(T object) {
        this.object = object;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public boolean addParents(T object) {
        boolean rez = true;
        int diff = this.object.getBirthday().getYear() - object.getBirthday().getYear();
        if (parents.size() == 0 && diff >= object.getPuberty()) {
            parents.add(object);
        } else if ((parents.size() == 1 && diff >= object.getPuberty()) && (parents.get(0).getGender() == Gender.male) && (object.getGender() == Gender.female)) {
            parents.add(object);
        } else if ((parents.size() == 1 && diff >= object.getPuberty()) && (parents.get(0).getGender() == Gender.female) && (object.getGender() == Gender.male)) {
            parents.add(object);
        } else {
            System.out.println("не может быть родителем этому объекту");
            rez = false;
        }
        return rez;
    }

    public boolean addChildren(T object) {
        boolean rez = true;
        int diff = object.getBirthday().getYear() - this.object.getBirthday().getYear();
        if (diff >= object.getPuberty()) {
            children.add(object);
        } else {
            System.out.println("не может быть ребенком этому человеку");
            rez = false;
        }
        return rez;
    }

    @Override
    public Gender getGender() {
        return object.getGender();
    }

    @Override
    public Date getBirthday() {
        return object.getBirthday();
    }

    @Override
    public String getName() {
        return object.getName();
    }

    public int getPuberty() {
        return object.getPuberty();
    }

    public T getObject() {
        return object;
    }

    @Override
    public List getListFields() {
        return object.getListFields();
    }

    @Override
    public void setName(String name) {
        object.setName(name);
    }

    @Override
    public void setBirthday(Date birthday) {
        object.setBirthday(birthday);
    }

    @Override
    public void setGender(Gender gender) {
        object.setGender(gender);
    }

    public List<T> getParents() {
        return parents;
    }

    public List<T> getChildren() {
        return children;
    }

    public List<T> getFilterParents(Selection selection) {
        return parents.stream().filter(selection::isEqual).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String parent = "parents: \n";
        if (parents.size()>0) {
            for (FamilyInterface parent1 : parents) {
                parent = parent + ((parent1.getGender() == Gender.female) ? "mother " : "father ") + parent1 + "\n";
            }
        } else { parent = "";}
        String child = "children: \n";
        if (children.size()>0) {
            for (FamilyInterface children1 : children) {
                child = child + ((children1.getGender() == Gender.female) ? "daughter " : "son ") + children1 + "\n";
            }
        } else { child = "\n";}

        return "\nFamilyTree for object: " + object + "\n" + parent + child;
    }
}
