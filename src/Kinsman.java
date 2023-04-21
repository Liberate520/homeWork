package java_oop_homeWork.src;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.text.*;

public class Kinsman implements Serializable {
    private FamilyTree family;
    private Date dateBirth;
    private String name;
    private String surName;
    private Sex sex;
    private Kinsman father;
    private Kinsman mother;
    private HashSet<Kinsman> childs;
    private Date dateDeath;
    private boolean alive;

    private Kinsman(String name, String surName, Sex sex, String dateBirth, String dateDeath, boolean alive) {
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
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
        this.childs = new HashSet<>();
    }
    public Kinsman(String name, String surName, Sex sex, String dateBirth, String dateDeath) {
        this(name, surName, sex, dateBirth, dateDeath, false);
    }
    public Kinsman(String name, String surName, Sex sex, String dateBirth, boolean alive) {
        this(name, surName, sex, dateBirth, null, alive);
    }
    public Kinsman(String name, String surName, Sex sex, boolean alive) {
        this(name, surName, sex, null, null, alive);
    }
    public Kinsman(String name, String surName, Sex sex, String dateDeath) {
        this(name, surName, sex, null, dateDeath, false);
    }
    public Kinsman(String name, String surName, Sex sex) {
        this(name, surName, sex, null, null, true);
    }

    public FamilyTree getFamily() { return this.family; }
    public void setFamily(FamilyTree family) { this.family = family; }

    public Kinsman getMother() { return this.mother; }
    private boolean setMother(Kinsman mother) {
        if (this.mother == null) {
            this.mother = mother;
            return true;
        }
        return false;
    }
    public Kinsman getFather() { return this.father; }
    private boolean setFather(Kinsman father) {
        if (this.father == null) {
            this.father = father;
            return true;
        }
        return false;
    }
    public HashSet<Kinsman> getChilds() { return this.childs; }
    public void addChild(Kinsman child) { this.childs.add(child); }

    public Sex getSex() { return this.sex; }

    public boolean setParent(Kinsman parent) {
        if (parent.getSex() == Sex.men) {
            return this.setFather(parent);
        }
        return this.setMother(parent);
    }

    public String getInfo() {
        Locale locale = new Locale("ru");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getFamilyInfo());
        sb.append(" ");
        sb.append(name);
        sb.append(" ");
        sb.append(surName);
        sb.append(" ");
        sb.append(sex);
        sb.append(" ");
        sb.append(String.format(locale, "%tF", dateBirth));
        sb.append(" ");
        sb.append(String.format(locale, "%tF", dateDeath));
        sb.append(" ");
        sb.append(this.getAliveInfo());
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

    public void printChilds() {
        for (Kinsman kinsman: this.childs) {
            System.out.println(kinsman.toString());
        }
    }

}
