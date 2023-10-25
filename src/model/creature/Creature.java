package model.creature;

import model.FamilyTree.Interface.CreatureItem;
import model.creature.Interface.AgeInfo;
import model.creature.methods.Print;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Creature implements Serializable, Comparable<Creature>, CreatureItem<Creature> {
    private long id;
    private String Name;
    private Gender gender;
    private LocalDate dataBirth;
    private LocalDate dataDeath;
    private Creature mother;
    private Creature father;
    private List<Creature> children;

    public Creature(String name, Gender gender, LocalDate dataBirth, LocalDate dataDeath, Creature mother,
                    Creature father) {
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

    public Creature(String name, Gender gender, LocalDate dataBirth, Creature father, Creature mother) {
        this(name, gender, dataBirth, null, mother, father);
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
//        stringBuilder.append(", ");
//        stringBuilder.append(getSpouseInfo());
        stringBuilder.append(", ");
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

    @Override
    public Creature getMother() {
        return mother;
    }

    @Override
    public void setMother(Creature mother) {
        this.mother = mother;
    }

    @Override
    public Creature getFather() {
        return father;
    }

    @Override
    public void setFather(Creature father) {
        this.father = father;
    }

    @Override
    public List<Creature> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<Creature> children) {
        this.children = children;
    }

    @Override
    public int compareTo(Creature o) {
        return Name.compareTo(o.getName());
    }
}
