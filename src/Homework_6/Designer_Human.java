package Homework_6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Описываем сущность вида human
 */
public class Designer_Human implements Serializable, Comparable<Designer_Human> {
    Femily_Tree femily_tree;

    //создаем поля в классе
    private String name;
    private String sex;
    private int date;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getDate() {
        return date;
    }


    private String father; // Объектная переменная

    private Designer_Human mother; // Объектная переменная

    private List<Designer_Human> children;


    private static List<Designer_Human> humans;

    public List<Designer_Human> getHumans() {
        return humans;
    }

    public Designer_Human(List<Designer_Human> humans) {
        Homework_6.Designer_Human.humans = humans;
    }

    public Designer_Human(String personName) {
        this(new ArrayList<>());
    }


    /*
     * Создаем максимально описанный конструктор
     */
    public Designer_Human(String name, String sex, int date, String father, Designer_Human mother) {
        this();
        this.name = name;
        this.sex = sex;
        this.date = date;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        humans = new ArrayList<>();


    }

    /*
     * Создаем конструктор на случей отсутствия родителей.
     */
    public Designer_Human(String name, String sex, int date) {
        this();
        this.name = name;
        this.sex = sex;
        this.date = date;
    }

    /*
     * конструктор с добавлением id
     */
    public Designer_Human(int id, String name, String sex, int date) {
        this();
        this.name = name;
        this.sex = sex;
        this.date = date;
        humans = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    /**
     * Пустой конструктор
     */
    public Designer_Human() {

    }


    public void setFather(String father) {
        this.father = father;
    }


    public void setMother(Designer_Human mother) {
        this.mother = mother;
    }

    public List<Designer_Human> getChildren() {
        return children;
    }


    /**
     * Переопределение toString
     *
     * @return Делаем перегрузку
     */
    @Override
    public String toString() {
        return "Имя: " + getName() + " Возраст: " + getDate() + " Пол : " + getSex() + " Мать : " + mother + " " +
                " Отец : " + father;
    }


    @Override
    public int compareTo(Homework_6.Designer_Human o) {
        return name.compareTo(o.getName());
    }

}


