package human;

import familyTree.FamilyTreeItem;
import writer.Writable;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyTreeItem {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private List<Human> children;
    private Human mother;
    private Human father;


    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDay, Human mother, Human father){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();

    }
    public Human(String name, Gender gender, LocalDate birthDay){
        this(name, gender, birthDay, null, null, null);

    }
    public Human(String name, Gender gender, LocalDate birthDay, Human mother, Human father){
        this(name, gender, birthDay, null, mother, father);
    }
    public int getAge(){
        if (deathDay == null){
            return getPeriod(birthDay, LocalDate.now());
        } else{
            return getPeriod(birthDay, deathDay);
        }
    }
    private int getPeriod(LocalDate birthDay, LocalDate deathDay){
        Period diff = Period.between(birthDay, deathDay);
        return  diff.getYears();
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human children) {
        this.children.add(children);
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(gender);
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
        String res = "мать: ";
        if (mother != null){
            res+= mother.getName();
        } else{
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null){
            res+= father.getName();
        } else{
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
        } else{
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public String toString() { //TODO Доработать! Сделать универсальным и настроить вывод только имён детей
        return getInfo();
    }
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() ==getId();
    }
}
