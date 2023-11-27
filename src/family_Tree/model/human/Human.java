package family_Tree.model.human;

import family_Tree.model.familyTree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, FamilyTreeItem<Human> {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

    public Human(int id, String name, LocalDate dateOfBirth, Gender gender, Human mother, Human father) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(int id, String name, LocalDate dateOfBirth, Gender gender) {
        this(id, name, dateOfBirth, gender, null, null);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        if(father != null){
            res += father.getName();
        } else {
            res += "информация отсутствует";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if(mother != null){
            res += mother.getName();
        } else {
            res += "информация отсутствует";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("информация отсутствует");
        }
        return res.toString();
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public List<Human> getParents () {
        List<Human> list = new ArrayList<>(2);
        if(father != null){
            list.add(father);
        }
        if(mother != null){
            list.add(mother);
        }
        return list;
    }

    public String getAge() {
        if (this.dateOfDeath == null) {
            return Integer.toString(getPeriod(this.dateOfBirth, LocalDate.now()));
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("умер(ла) в ").append(getPeriod(this.dateOfBirth, this.dateOfDeath));
            return stringBuilder.toString();
        }
    }

    private int getPeriod(LocalDate start, LocalDate end){
        Period difference = Period.between(start, end);
        return difference.getYears();
    }

    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(id);
        info.append(", имя: ");
        info.append(name);
        info.append(", пол: ");
        info.append(getGender());
        info.append(", возраст: ");
        info.append(getAge());
        info.append(", ");
        info.append(getMotherInfo());
        info.append(", ");
        info.append(getFatherInfo());
        info.append(", ");
        info.append(getChildrenInfo());

        return info.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human human)) {
            return false;
        }
        return human.getId() == getId();
    }

    @Override
    public String toString(){
        return getInfo();
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
