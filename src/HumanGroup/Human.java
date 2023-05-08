package Tree.homeWork.src.HumanGroup;

import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human> {
    private String name;
    private int age;
    private int dateOfDeath;
    private int dateOfBirth;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;
//    public Human(String name, Gender gender) {this(name, gender, null, null);}    Зачем 2 конструктора?
    public Human(String name, int age, int DateOfBirth, int DateOfDeath, Gender gender,
                 Human father, Human mother){
        this.name = name;
        this.age = age;
        this.dateOfBirth = DateOfBirth;
        this.dateOfDeath = DateOfDeath;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(String name, int age, int dateOfBirth, int dateOfDeath, Gender gender, String father, String mother) {
        this(name,age,dateOfBirth,dateOfDeath,gender,mother, father);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Human getFather() {return father;}
    public Human getMother() {return mother;}
    public List<Human> getChildren() {return children;}
    public int age() {
        return age;
    }
    public int DateOfBirth() {
        return dateOfBirth;
    }
    public int DateOfDeath() {
        return dateOfDeath;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFather(Human father) {this.father = father;}
    public void setMother(Human mother) {this.mother = mother;}
    public Gender getGender() {
        return gender;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append("Возраст: ");
        sb.append(age);
        sb.append(" Пол: " );
        sb.append(gender);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());

        return sb.toString();
    }
    public String getMotherInfo(){
        String res = "мать: ";
        if (mother!= null){
            res += mother.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        if (father!= null){
            res += father.getName();
        } else {
            res += "неизвестно";
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
    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
