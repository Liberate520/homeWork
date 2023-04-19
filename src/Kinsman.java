package java_oop_homeWork.src;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Kinsman {
    private FamilyTree family;
    private Date dateBirth;
    private String name;
    private String surName;
    private Sex sex;
    private Kinsman father;
    private Kinsman mother;
    private HashSet<Kinsman> scions;
    private Date dateDeath;
    private boolean alive;

    private Kinsman(String name, String surName, Sex sex, Date dateBirth, Date dateDeath, boolean alive) {
        this.name = name;
        this.surName = surName;
        this.sex = sex;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.alive = alive;
        this.scions = new HashSet<>();
    }
    public Kinsman(String name, String surName, Sex sex, Date dateBirth, Date dateDeath) {
        this(name, surName, sex, dateBirth, dateDeath, false);
    }
    public Kinsman(String name, String surName, Sex sex, Date dateBirth, boolean alive) {
        this(name, surName, sex, dateBirth, null, alive);
    }
    public Kinsman(String name, String surName, Sex sex, boolean alive) {
        this(name, surName, sex, null, null, alive);
    }
    public Kinsman(String name, String surName, Sex sex, Date dateDeath) {
        this(name, surName, sex, null, dateDeath, false);
    }
    public Kinsman(String name, Sex sex, Date dateBirth, boolean alive) {
        this(name, null, sex, dateBirth, null, alive);
    }
    public Kinsman(String name, Sex sex, Date dateBirth, Date dateDeath) {
        this(name, null, sex, dateBirth, dateDeath, false);
    }
    public Kinsman(String name, String surName, Sex sex) {
        this(name, surName, sex, null, null, true);
    }
    public Kinsman(String name, Sex sex, boolean alive) {
        this(name,null, sex, null, null, alive);
    }
    public Kinsman(String name, Sex sex, Date dateDeath) {
        this(name,null, sex, null, dateDeath, false);
    }
    public Kinsman(String name, Sex sex) {
        this(name, null, sex, null,  null, true);
    }

    public void setFamily(FamilyTree family) { this.family = family; }

    private void addMother(Kinsman mother) { this.mother = mother; }
    private void addFather(Kinsman father) { this.father = father; }
    public void addScion(Kinsman scion) { this.scions.add(scion); }

    public Sex getSex() { return this.sex; }

    public void addParent(Kinsman parent) {
        if (parent.getSex() == Sex.men) {
            this.addFather(parent);
        }
        else this.addMother(parent);
    }

    @Override
    public String toString() {
        String aliveStr = alive ? "жив" : "мёртв";
        String familyStr = family == null ? "-" : family.getName();
        return familyStr + " " + name + " " + surName + " " + sex + " " + dateBirth + " " + dateDeath + " " + aliveStr;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Kinsman) {
            Kinsman kinsman = (Kinsman) obj;
            return name.equals(kinsman.name) && surName.equals(kinsman.surName) && sex.equals(kinsman.sex)
                    && dateBirth.equals(kinsman.dateBirth) && dateDeath.equals(kinsman.dateDeath)
                    && father.equals(kinsman.father) && mother.equals(kinsman.mother);
        }
        return false;
    }

    @Override
    public int hashCode() { return Objects.hash(name, surName, sex, dateBirth, dateDeath, father, mother); }

    public void printScions() {
        for (Kinsman kinsman: this.scions) {
            System.out.println(kinsman.toString());
        }
    }
}
