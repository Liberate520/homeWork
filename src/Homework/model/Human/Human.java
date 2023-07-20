package Homework.model.Human;

import Homework.model.Tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyTreeItem {

    private String name;
    private Gender gender;
    private LocalDate birth;
    private LocalDate death;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birth, LocalDate death, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.death = death;
        parents = new ArrayList<>();
        if (father != null){parents.add(father);}
        if (mother != null){parents.add(mother);}
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birth){
        this(name, gender, birth, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birth, Human father, Human mother){
        this(name, gender, birth, null, father, mother);
    }

    public Human(String name, Gender gender, LocalDate birth, LocalDate death){
        this(name, gender, birth, death, null, null);
    }

    public Human(String name, Gender gender, LocalDate birth, Human father){
        this(name, gender, birth, father, null);
    }


    public boolean addChild(Object child){
        if(!children.contains(child)){
            children.add((Human)child);
            return true;
        }
        return false;
    }

    public String getName() {return name;}

    public boolean addParent(Human parent){
        if(!parents.contains(parent)){
            children.add(parent);
            return true;
        }
        return false;
    }

    public LocalDate getBirth() {return birth;}

    public LocalDate getDeath() {return death;}

    @Override
    public void setId(long id) {

    }

    @Override
    public long genId() {
        return 0;
    }

    public Human getFather(){
        for(Human parent: parents){
            if(parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother(){
        for(Human parent: parents){
            if(parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    @Override
    public boolean addParent(Object human) {
        return false;
    }

    public List<Human> getParents() {return parents;}

    public List<Human> getChildren() {return children;}

    @Override
    public Object getSpouse() {
        return null;
    }

    public StringBuilder getChildAndAge(){
        StringBuilder sb = new StringBuilder();
        if(getChildren().size() != 0) {
            for (Human human : getChildren()) {
                sb.append(human.getName() + " (" + human.getAge() + " лет), ");

            }
        }
        else {
            sb.append("Информация о детях отсутствует!");
        }
        return sb;
    }

    public void setBirth(LocalDate birth) {this.birth = birth;}

    public void setDeath(LocalDate death) {this.death = death;}

    public Gender getGender() {return gender;}

    public int getAge(){
        if(death == null){
            return getYear(birth, LocalDate.now());
        }
        else{
            return getYear(birth, death);
        }
    }

    private int getYear(LocalDate birth, LocalDate death) {
        Period diff = Period.between(birth, death);
        return diff.getYears();
    }

    @Override
    public String toString() {return getInfo();}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ФИО: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo(){
        String res = "Мать: ";
        Human mother = getMother();
        if(mother != null){
            res += mother.getName();
        } else {
            res += "Неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "Отец: ";
        Human father = getFather();
        if(father != null){
            res += father.getName();
        } else {
            res += "Неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("Отсутствуют");
        }
        return res.toString();
    }

    public List<String> getGrandsInfo(){
        List<Human> parents = getParents();
        List<String> res = new ArrayList<>();
        for (Human b: parents) {
            for (Human grand : b.getParents()) {
                res.add(grand.getName());
            }
        }
        if (res.isEmpty()){
            res.add("Информация отсутствует");
            return res;
        }
        return res;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }
}
