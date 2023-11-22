package Family_Tree.Human;

import Family_Tree.Tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, TreeNode<Human> {
    private int id;
    private String name;
    private LocalDate birthday;
    private LocalDate death;
    private Gender gender;
    private Human mom;
    private Human dad;
    private List<Human> children;
    private Human spouse;

    public Human(String name, LocalDate birthday, LocalDate death, Gender gender, Human mom, Human dad) {
        id = -1;
        this.name = name;
        this.birthday = birthday;
        this.death = death;
        this.gender = gender;
        this.mom = mom;
        this.dad = dad;
        children = new ArrayList<>();
    }

    public void addChildren(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public void addParent(Human parent) {
        if (parent.getGender().equals(Gender.Female)) {
            setMom(parent);
        } else if (parent.getGender().equals(Gender.Male)) {
            setDad(parent);
        }
    }

    public void setMom(Human mom) {
        this.mom = mom;
    }

    public void setDad(Human dad) {
        this.dad = dad;
    }

    public Human getMom() {
        return mom;
    }

    public Human getDad() {
        return dad;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (mom != null) {
            list.add(mom);
        }
        if (dad != null) {
            list.add(dad);
        }
        return list;
    }

    private int getTime(LocalDate birthday, LocalDate death) {
        Period time = Period.between(birthday, death);
        return time.getYears();
    }

    public int getAge() {
        if (death == null) {
            return getTime(birthday, LocalDate.now());
        } else {
            return getTime(birthday, death);
        }
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {return birthday;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMomInfo());
        sb.append(", ");
        sb.append(getDadInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();

    }

    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMomInfo() {
        String res = "мама: ";
        if (mom == null) {
            res += "нет";
        } else {
            res += mom.getName();
        }
        return res;
    }

    public String getDadInfo() {
        String res = "папа: ";
        if (dad == null) {
            res += "нет";
        } else {
            res += dad.getName();
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("нету");
        }
        return res.toString();
    }

//    public void setName(String name) {
//        this.name = name;
//    }

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
        return this.name.compareTo(o.name);
    }
}
