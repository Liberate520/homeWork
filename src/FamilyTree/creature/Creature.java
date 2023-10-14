package FamilyTree.creature;

import FamilyTree.FamilyTree.CreatureItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Creature implements Serializable, Comparable<Creature>, CreatureItem<Creature> {
    private long id;
    private String Name;
    private Gender gender;
    private LocalDate dataBirth;
    private LocalDate dataDeath;
    private Creature mother;
    private Creature father;
    private Creature spouse;
    private List<Creature> children;

    public Creature(String name, Gender gender, LocalDate dataBirth, LocalDate dataDeath, Human mother, Human father) {
        id = -1;
        Name = name;
        this.gender = gender;
        this.dataBirth = dataBirth;
        this.dataDeath = dataDeath;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Creature(String name, Gender gender, LocalDate dataBirth) {
        this(name, gender, dataBirth, null, null, null);
    }

    public Creature(String name, Gender gender, LocalDate dataBirth, Human father, Human mother) {
        this(name, gender, dataBirth, null, mother, father);
    }

    public boolean addChildren(Creature child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public void addParent(Creature parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
    }

    public int getAge() {
        if (dataDeath == null) {
            return getPeriod(dataBirth, LocalDate.now());
        } else {
            return getPeriod(dataBirth, dataDeath);
        }
    }

    public int getPeriod(LocalDate dataBirth, LocalDate dataDeath) {
        Period diff = Period.between(dataBirth, dataDeath);
        return diff.getYears();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append(", name: ");
        stringBuilder.append(Name);
        stringBuilder.append(", gender: ");
        stringBuilder.append(gender);
        stringBuilder.append(", age: ");
        stringBuilder.append(getAge());
        stringBuilder.append(", ");
        stringBuilder.append(", ");
        stringBuilder.append(getSpouseInfo());
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getChildrenInfo());
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getSpouseInfo() {
        String res = "spouse: ";
        if (spouse == null) {
            res += "no";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public Creature getSpouse() {
        return spouse;
    }

    public void setSpouse(Creature spouse) {
        this.spouse = spouse;
    }

    public String getMotherInfo() {
        String res = "mother: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "father: ";
        if (father != null) {
            res += father.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("unknown");
        }
        return res.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Creature)) {
            return false;
        }
        Creature creature = (Creature) obj;
        return creature.getId() == getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDataBirth() {
        return dataBirth;
    }

    public void setDataBirth(LocalDate dataBirth) {
        this.dataBirth = dataBirth;
    }

    public LocalDate getDataDeath() {
        return dataDeath;
    }

    public void setDataDeath(LocalDate dataDeath) {
        this.dataDeath = dataDeath;
    }

    public Creature getMother() {
        return mother;
    }

    public void setMother(Creature mather) {
        this.mother = mather;
    }

    public Creature getFather() {
        return father;
    }

    public void setFather(Creature father) {
        this.father = father;
    }

    public List<Creature> getChildren() {
        return children;
    }

    public void setChildren(List<Creature> children) {
        this.children = children;
    }

    @Override
    public int compareTo(Creature o) {
        return Name.compareTo(o.getName());
    }
}
