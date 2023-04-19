package Tree.model.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// класс описывающий сущность "человек"
public class Human implements Serializable {

    private String fullName;
    private int yearOfBirth;
    private Human mother;
    private Gender sex;
    private Human father;
    private List<Human> children;

    // конструкторы
    public Human(String fullName, int dateBirth, Gender sex) {
        this(fullName, dateBirth, sex, null, null);
    }

    public Human(String fullName, int dateBirth, Gender sex, Human mother, Human father) {
        this.fullName = fullName;
        this.yearOfBirth = dateBirth;
        this.sex = sex;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    // геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Gender getSex() {return sex;}

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setSex(Gender sex) {this.sex = sex;}

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    // метод выдает информацию о человеке
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: " + getFullName());
        sb.append(", г.р.: " + getYearOfBirth());
        sb.append(", пол: " + getSex());
        sb.append(", мать: " + checkMother());
        sb.append(", отец: " + checkFather());
        sb.append(", дети: " + checkChildren() + "\n");
        return sb.toString();
    }

    // метод проверки наличия матери
    public String checkMother() {
        if (mother == null) return " - ";
        else return mother.getFullName();
    }

    // метод проверки наличия отца
    public String checkFather() {
        if (father == null) return " - ";
        else return father.getFullName();
    }

    // метод проверки наличия детей
    public String checkChildren() {
        StringBuilder res = new StringBuilder();
        if (children.size() != 0) {
            res.append(children.get(0).getFullName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getFullName());
            }
        } else {
            res.append(" - ");
        }
        return res.toString();
    }

    // метод добавления детей
    public void addChild(Human human) {
        if (!children.contains(human)) {
            children.add(human);
        }
    }

    // метод удаляет запись о матери
    public void removeMother() {
        mother = null;
    }

    // метод удаляет запись об отце
    public void removeFather() {
        father = null;
    }

    // метод удаляет запись о детях
    public void removeChild(Human human) {
        children.remove(human);
    }

    // метод переопределяет встроенный метод сравнения двух экземпляров класса human
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human human)) return false;
        return human.getFullName().equals(getFullName());
    }
}
