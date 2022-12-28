package gb.task_4;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Human extends LiveBeing {
    private String name;
    private int date;
    private String sex;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, int date, String sex) {
        this.name = name;
        this.date = date;
        this.sex = sex;
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public Human(String name) {
        this.name = name;
        this.date = generateNowDate();
        this.sex = getRandomSex();
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDate() {
        return this.generateNowDate();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Human> getChildren() {
        return this.children;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected int generateNowDate() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected String getRandomSex() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFather(Human father) {
        this.father = father;

    }

    @Override
    public void setMother(Human mother) {
        this.mother = mother;

    }

}
