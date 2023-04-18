package OOPjavaTree.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private int birthdate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human (String name, int birthdate, Human father, Human mother) {
        this.name = name;
        this.birthdate = birthdate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human (String name, int birthdate){
        this(name, birthdate,null, null);
    }

    //Вывод детальной информации Персоны (для функции комадной строки)
    public String getString (){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ").append(name).append(", ");
        sb.append("Год рождения: ").append(birthdate).append(", ");
        sb.append(getFatherInfo()).append(", ");
        sb.append(getMotherInfo());
        return sb.toString();
    }

    public String getFatherInfo(){
        String result = "Отец: ";
        if (father != null){
            result += father.getName();
        }
        else {
            result += "Не известно";
        }
        return result;
    }

    public String getMotherInfo(){
        String result = "Мать: ";
        if (mother != null){
            result += mother.getName();
        }
        else {
            result += "Не известно";
        }
        return result;
    }

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return human.getName().equals(getName());
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Год рождения: " + birthdate;
    }
}