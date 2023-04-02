package oop_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// класс содержащий всю информацию о людях
public class Person implements Serializable {

    private String fullName;
    private int dateBirth;
    private Gender sex;
    private Person mother;
    private Person father;
    private List<Person> childrenList;

    // конструктор с 5 параметрами
    public Person(String fullName, int dateBirth, Gender sex, Person mother, Person father) {
        this.fullName = fullName;
        this.dateBirth = dateBirth;
        this.sex = sex;
        this.mother = mother;
        this.father = father;
        childrenList = new ArrayList<>();
    }
    // конструктор с 3 параметрами
    public Person(String fullName, int dateBirth, Gender sex) {

        this(fullName, dateBirth, sex, null, null);
    }
    // пустой конструктор
    public Person() {

    }
    // геттеры и сеттеры
    public Gender getSex() {return sex;}

    public String getFullName() {
        return fullName;
    }

    public int getDateBirth() {
        return dateBirth;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return childrenList;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateBirth(int dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setSex(Gender sex) {this.sex = sex;}

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {this.father = father;}

    public void setChildren(List<Person> childrenList) {
        this.childrenList = childrenList;
    }

    // метод поиска матери
    public String getMotherInfo() {
        String res = "мать: ";
        if (mother != null) {
            res += mother.getFullName();
        } else {
            res += " - ";
        }
        return res;
    }
    // метод поиска отца
    public String getFatherInfo() {
        String res = "отец: ";
        if (father != null) {
            res += father.getFullName();
        } else {
            res += " - ";
        }
        return res;
    }
    // метод сравнения объектов класса Person
    public boolean equals(Object obg) {
        if (this == obg) {
            return true;
        }
        if (!(obg instanceof Person person)) {
            return false;
        }
        return person.getFullName().equals(getFullName());
    }
    // метод вывода информации об объекте person по умолчанию
    @Override
    public String toString() {
        return "Full name: " + getFullName() + ", пол: " + sex + ", Year of birth: "
                + getDateBirth() + ", Mother: " + getMotherInfo() + ", Father: "
                + getFatherInfo() + ", Children: " + getChildrenInfo() + "\n";
    }
    // основной метод вывода информации об объекте класса Person
    public String getInfoPerson() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(getFullName());
        sb.append(", ");
        sb.append("пол: ");
        sb.append(getSex());
        sb.append(", ");
        sb.append(getDateBirth());
        sb.append(" г.р. ,");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    // метод поиска детей у объектов класса Person
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (childrenList.size() != 0) {
            res.append(childrenList.get(0).getFullName());
            for (int i = 1; i < childrenList.size(); i++) {
                res.append(", ");
                res.append(childrenList.get(i).getFullName());
            }
        } else {
            res.append(" - ");
        }
        return res.toString();
    }
    // метод добавления детей
    public void addChild(Person child) {
        if (!childrenList.contains(child)) {
            childrenList.add(child);
        }
    }
}