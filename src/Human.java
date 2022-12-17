//package FamilyTree;

import java.time.Year;
import java.util.*;

public class Human {
    private String name;
    private int date;
    private String sex;
    private Human father;
    private List<Human> children;

    public Human(String name, int data, String sex, Human father) {
        this.name = name;
        this.date = date;
        this.sex = sex;
        this.father = father;
        this.children = new ArrayList<>();
        father.getChildren().add(this);
    }

    public Human(String name, Human father) {
        this.name = name;
        this.date = getDate();
        this.sex = getRandomSex();
        this.father = father;
        this.children = new ArrayList<>();
        father.getChildren().add(this);
    }

    public Human(String name, int date, String sex) {
        this.name = name;
        this.date = date;
        this.sex = sex;
        this.father = null;
        this.children = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (this.father == null && this.children == null)
            return String.format("name: %s, date: %s, sex: %s\nFather: %s\nChildren: NaN\n",
                    this.name, this.date, this.sex, this.father);
        else if (this.father == null)
            return String.format("name: %s, date: %s, sex: %s\nFather: %s\nChildren: %s\n",
                    this.name, this.date, this.sex, this.father, this.children);
        else
            return String.format("name: %s, date: %s, sex: %s\nFather: %s\nChildren: %s\n",
                    this.name, this.date, this.sex, this.father.getName(),
                    this.children.toString().replaceAll("\\[\\]", ""));
    }

    private int getDate() {
        int date = Year.now().getValue();
        // String d = date();
        return date;
    }

    private String getRandomSex() {
        Random random = new Random();
        int rnd = random.nextInt(0, 2);
        if (rnd == 0)
            return "female";
        else
            return "male";
    }
}