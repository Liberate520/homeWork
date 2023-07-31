package genealogy_tree.Human;

import genealogy_tree.Tree.GeneologiTreeItem;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Human implements Serializable, Comparable<Human>, GeneologiTreeItem<Human> {

    private long id;
    private List<Human> parents;
    private List<Human> children;
    private Gender gender;
    private String name;

    private LocalDate birthDate;
    private LocalDate deathDate;

    private Human spouse;

    public Human(long id, String name, Gender gender, Human father, Human mother, LocalDate birthDate, LocalDate deathDate) {
        this.id = id;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.name = name;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(long id, String name, Gender gender, LocalDate birthDate) {
        this(id, name, gender, null, null, birthDate, null);
    }

    public Human(Long id, String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(id, name, gender, father, mother, birthDate, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParents(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public String getName() {

        return name;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int getLife(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public int getAge() {
        if (deathDate == null) {
            return getLife(birthDate, LocalDate.now());
        } else {
            return getLife(birthDate, deathDate);
        }
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {

        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {

        return gender;
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(",  ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(",  ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getSpouseInfo() {
        String result = "spouse: ";
        if (spouse == null) {
            result += "without spouses";
        } else {
            result += spouse.getName();
        }
        return result;
    }

    public String getMotherInfo() {
        String result = " mother: ";
        Human mother = getMother();
        if (mother != null) {
            result += mother.getName();
        } else {
            result += "unknown";
        }
        return result;
    }

    public String getFatherInfo() {
        String result = " father: ";
        Human father = getFather();
        if (father != null) {
            result += father.getName();
        } else {
            result += "unknown";
        }
        return result;
    }

    public String getChildrenInfo() {
        StringBuilder result = new StringBuilder();
        result.append("children: ");
        if (children.size() != 0) {
            result.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                result.append(", ");
                result.append(children.get(i).getName());
            }
        } else {
            result.append("null");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}