package homeWork3.core.mvp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Model implements Serializable, Comparable<Model> {
    private String name;
    private String gender;
    private int age;
    private Model mother;
    private Model father;
    private List<Model> kids;

    public Model(String name, String gender, int age, Model mother, Model father) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mother = mother;
        this.father = father;
        kids = new ArrayList<>();
    }

    public Model(String name, String gender, int age) {
        this(name, gender, age, null, null);
    }

    public void addKid(Model kid) {
        if (!kids.contains(kid)) {
            this.kids.add(kid);
            if (Objects.equals(this.gender, "мужской")) {
                kid.father = this;
            } else
                kid.mother = this;
        }
    }

    public String printKids() {
        StringBuilder res = new StringBuilder(" Дети: ");
        if (!this.kids.isEmpty()) {
            for (Model kid : kids) {
                res.append(kid.name).append(",");
            }
        } else
            res.append(" нет");
        return res.toString();
    }

    @Override
    public String toString() {
        String res = "Имя: " + name + ",\t Пол: " + gender + ", Возраст: " + age;
        if (this.mother != null) {
            res += ", Мать: " + mother.name;
        } else
            res += ", Мать: неизвестна";

        if (this.father != null) {
            res += ", Отец: " + father.name + ",";
        } else
            res += ", Отец: неизвестен,";

        res += printKids();

        return res;
    }

    public String getName() {
        return name;
    }

    public Model getFather() {
        return father;
    }

    public Model getMother() {
        return mother;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Model o) {
        return name.compareToIgnoreCase(o.name);
    }
}