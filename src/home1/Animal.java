package home1;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private String sex;
    private int age;
    private Animal mother;
    private Animal father;
    private List<Animal> children;

    public Animal(String name, String sex, int age, Animal mother, Animal father) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Animal(String name, String sex, int age) {
        this(name, sex, age, null, null);
    }

    public void addChild(Animal child) {
        if (!children.contains(child)) {
            this.children.add(child);
            if (this.sex == "муж.") {
                child.father = this;
            } else
                child.mother = this;
        }
    }

    public String printChildren() {
        String res = " Дети: ";
        if (!this.children.isEmpty()) {
            for (int i = 0; i < children.size(); i++) {
                res += children.get(i).name + ",";
            }
        } else
            res += " нет";
        return res;
    }

    @Override
    public String toString() {
        String res = "Имя: " + name + ",\t Пол: " + sex + ", Возраст: " + age;
        if (this.mother != null) {
            res += ", Мать: " + mother.name;
        } else
            res += ", Мать: неизвестна";

        if (this.father != null) {
            res += ", Отец: " + father.name + ",";
        } else
            res += ", Отец: неизвестен,";

        res += printChildren();

        return res;
    }

    public String getName() 
    {
        return name;
    }

    public Animal getFather() 
    {
        return father;
    }

    public Animal getMather() 
    {
        return mother;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }
}
