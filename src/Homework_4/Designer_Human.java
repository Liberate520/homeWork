package Homework_4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Описываем сущность вида human
 */
public class Designer_Human implements Serializable, Comparable<Designer_Human> {
    public Femily_Tree Designer_Human;
    //создаем поля в классе
    private String name;
    private String sex;
    private int date;

    public String getName() {
        return name;
    }


//    public void setName(String name) {
//        this.name = name;
//    }

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

    public Designer_Human(List<Designer_Human> humans) {
        Homework_4.Designer_Human.humans = humans;
    }

    public Designer_Human() {
        this(new ArrayList<>());
    }


    /*
     * Создаем максимально описанный конструктор
     */
    public Designer_Human(String name, String sex, int date, String father, Designer_Human mother) {
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


    public void setFather(String father) {
        this.father = father;
    }

//    public Designer_Human getMother() {
//        return mother;
//    }

    public void setMother(Designer_Human mother) {
        this.mother = mother;
    }

    public List<Designer_Human> getChildren() {
        return children;
    }

//    public void setChildren(List<Designer_Human> children) {
//        this.children = children;
//    }

    /**
     * Вариант добавления детей
     */
    public void addChildren() { // добавляем детей другим методом
        StringBuilder Child = new StringBuilder();
        if (this.children != null) {
            Child.append(getName());
            for (Designer_Human c : getChildren()) {
                Child.append(c.getName());
            }
        } else {
            Child.append("null");
        }
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

    /**
     * метод добавления очередной
     */
    public static void addHumanSimpleMetod(Designer_Human Human) {
        humans.add(Human);
    }

    @Override
    public int compareTo(Homework_4.Designer_Human o) {
        return name.compareTo(o.getName());
    }

    /**
     * Вариант добавления людей
     */
    public void addHuman(String name, String sex, int date) {
        Designer_Human HH = new Designer_Human(name, sex, date);
        humans.add(HH);
    }
}


