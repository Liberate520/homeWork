package human;

import Tree.HumanItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, HumanItem<Human>{
    private String name;
    private Gender gender;
    private String age;
    private LocalDate dateBorn;
    private LocalDate dateDeath;
    private List<Human> parents;
    private List<Human> children;
    
    public Human(String name, Gender gender, String age, LocalDate dateBorn, LocalDate dateDeath, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dateBorn = dateBorn;
        this.dateDeath = dateDeath;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, String age, LocalDate dateBorn) {
        this(name, gender, age, dateBorn, null, null, null);
    }

    public Human(String name, Gender gender, String age, LocalDate dateBorn, Human father, Human mother) {
        this(name, gender, age, dateBorn, null, father, mother);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent: parents){
            if (parent.getGender() == Gender.MALE){
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent: parents){
            if (parent.getGender() == Gender.FEMALE){
                return parent;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public String getAge() {
        return age;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(age);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
}
