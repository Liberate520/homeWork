package model.creature;

import model.FamilyTree.Interface.CreatureItem;
import model.creature.Interface.AgeInfo;
import model.creature.methods.Print;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Creature implements Serializable, Comparable<Creature>, CreatureItem {
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

    @Override
    public int compareTo(Creature o) {
        return Name.compareTo(o.getName());
    }
}
