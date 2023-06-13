package homeWork.tree2.backend.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Human implements Serializable, Comparable<Human>, HumanObjectInterface<Human> {
    private String name;
    private LocalDate birthdate;
    private Human mother;
    private Human father;
    private ArrayList<Human> children;
    private int id;
    private static int nextId = 1;

    @Override
    public String toString() {
        return "Имя: "+ this.name + " (Id=" + this.id +")";
    }

    public Human(String name, LocalDate birthdate, Human mother, Human father, ArrayList<Human> children) {
        this.name = name;
        this.birthdate = birthdate;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.id = nextId;
        nextId++;
    }

    public Human(String name, LocalDate birthdate) {
        this(name, birthdate, null, null, new ArrayList<>());
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public int getAge() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - birthdate.getYear();
    }

    public ArrayList<Human> getChildren() {
        return children;
    }


    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void updatePersonParameters(String name, LocalDate birthdate) {
        setName(name);
        setBirthdate(birthdate);
    }

}
/*
 Тут спорно. Класс по факту состоит из свойств и внутренних методов.
Сам Апдейтер updatePersonParameters можно было вынести отдельно, с другой стороны,
этот метод работает только с полями данного класса и только с конкретным экземпляром данного класса.
Но данный метод я немного переделал.
Мне самому не нравится наличие методов, которые в данный момент не используются, но они точно нужны
(т.к. класс должен быть расширяемым и мы явно показываем в какую сторону его стоит расширять).
 */

