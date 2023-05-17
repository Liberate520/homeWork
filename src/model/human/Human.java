package java_oop_homeWork.src.model.human;

import java_oop_homeWork.src.model.FamilyTreeItem;
import java_oop_homeWork.src.model.Sex;
import java_oop_homeWork.src.model.familyTree.FamilyTree;

import java.io.Serializable;
import java.util.*;
import java.text.*;

public class Human implements Serializable, Comparable<Human>, FamilyTreeItem {
    private int id;
    private FamilyTree family;
    private Date dateBirth;
    private String name;
    private String surName;
    private Sex sex;
    private Human father;
    private Human mother;
    private TreeSet<Human> childs;
    private Date dateDeath;
    private boolean alive;

    public Human(int id, String name, String surName, Sex sex, String dateBirth, String dateDeath, boolean alive) {
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.sex = sex;
        if (dateBirth != null) {
            try {
                this.dateBirth = ft.parse(dateBirth);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (dateDeath != null) {
            try {
                this.dateDeath = ft.parse(dateDeath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.alive = alive;
        this.childs = new TreeSet<>();
    }
    public Human(int id, String name, String surName, Sex sex, String dateBirth, String dateDeath) {
        this(id, name, surName, sex, dateBirth, dateDeath, false);
    }
    public Human(int id, String name, String surName, Sex sex, String dateBirth, boolean alive) {
        this(id, name, surName, sex, dateBirth, null, alive);
    }
    public Human(int id, String name, String surName, Sex sex, boolean alive) {
        this(id, name, surName, sex, null, null, alive);
    }
    public Human(int id, String name, String surName, Sex sex, String dateDeath) {
        this(id, name, surName, sex, null, dateDeath, false);
    }
    public Human(int id, String name, String surName, Sex sex) {
        this(id, name, surName, sex, null, null, true);
    }

    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surName;
    }

    public FamilyTree getFamily() { return this.family; }
    public void setFamily(FamilyTree family) { this.family = family; }

    public Human getMother() { return this.mother; }
    public boolean setMother(FamilyTreeItem mother) {
        if (this.mother == null) {
            this.mother = (Human) mother;
            return true;
        }
        return false;
    }
    public Human getFather() { return this.father; }
    public boolean setFather(FamilyTreeItem father) {
        if (this.father == null) {
            this.father = (Human) father;
            return true;
        }
        return false;
    }
    public TreeSet<Human> getChilds() { return this.childs; }
    public void addChild(FamilyTreeItem child) { this.childs.add((Human) child); }

    public Sex getSex() { return this.sex; }

    public boolean setParent(FamilyTreeItem parent) {
        if (parent.getSex() == Sex.men) {
            return this.setFather(parent);
        }
        return this.setMother(parent);
    }

    public String getInfo() {
        Locale locale = new Locale("ru");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getFamilyInfo());
        sb.append(" ID:");
        sb.append(id);
        sb.append(" Имя:");
        sb.append(name);
        sb.append(" Фамилия:");
        sb.append(surName);
        sb.append(" Пол:");
        sb.append(sex);
        sb.append(" Дата рождения:");
        sb.append(String.format(locale, "%tF", dateBirth));
        sb.append(" Дата смерти:");
        sb.append(String.format(locale, "%tF", dateDeath));
        sb.append(" ");
        sb.append(" Отец:");
        if (father == null) sb.append("-");
        else sb.append(father.id + " " + father.name + " " + father.surName);
        sb.append(" Мать:");
        if (mother == null) sb.append("-");
        else sb.append(mother.id + " " + mother.name + " " + mother.surName);
//        sb.append(this.getAliveInfo());
        return sb.toString();
    }

    public String getAliveInfo() {
        return alive ? "жив" : "мёртв";
    }

    public String getFamilyInfo() {
        return family == null ? "-" : family.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Human) {
            Human human = (Human) obj;
            return id == human.id;
        }
        return false;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    public void printChilds() {
        for (Human human : this.childs) {
            System.out.println(human.toString());
        }
    }

    public Date getDateBirth() {
        return dateBirth;
    }
    public Date getDateDeath() {
        return dateDeath;
    }

    @Override
    public int compareTo(Human human) {
        return this.id - human.getID();
    }

}
