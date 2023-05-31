package tree;

import java.util.ArrayList;
import java.util.List;

/*
* Описание родственных связей надо сделать, человек может быть и родителем и ребенком
* */
public class Human {
    private String name; // имя человека
    private int age; // дата рождения
    private String gender; // пол true - men, false - women
    private  Human father;
    private  Human mother;
    private ArrayList<Human> children;

    public Human(String name, int age) {
        this(name, age, null, null);
    }

    public Human(String name, int age, Human father, Human  mother) {
        this.name = name;
        this.age = age;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public boolean childAdd(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

//    Получаем информацию по записи всех данных, включая родителей и детей
    public String getInfo() {
        StringBuilder out = new StringBuilder();
        out.append("all data: ");
        out.append("name: ");
        out.append(name);
        out.append("; ");
        out.append(getMeMother());
        out.append("; ");
        out.append(getMeFather());
        out.append("; ");
        out.append(getMeChild());
        return out.toString();
    }

//    получаем информацию про имя матери
    public String getMeMother(){
        String out = "mama: ";
        if(mother != null){
            out += mother.getName();
        } else {
            out += "no data";
        }
        return  out;
    }

//    получаем информацию про имя отца
    public String getMeFather(){
        String out = "mama: ";
        if(father != null){
            out += father.getName();
        } else {
            out += "no data";
        }
        return  out;
    }

//    получаем информацию про имя детей
    public String getMeChild(){
        StringBuilder out = new StringBuilder();
        out.append("children: ");
        if (children.size() != 0){
            out.append(children.get(0).getName());
            for (int i = 0; i < children.size(); i++) {
                out.append("; ");
                out.append(children.get(i).getName());
            }
        } else {
            out.append("no data");
        }
        return  out.toString();
    }

    public boolean equals(Object out){
        if (this == out) {
            return true;
        }
        if (!(out instanceof Human)) {
            return false;
        }

        Human human = (Human) out;
        return human.getName().equals(getName());
    }
}
