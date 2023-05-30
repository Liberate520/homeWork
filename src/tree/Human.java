package tree;

import java.util.List;

/*
* Описание родственных связей надо сделать, человек может быть и родителем и ребенком
* */
public class Human {
    private static int idn;
    private int id;
    private String name; // имя человека
    private int age; // дата рождения
    private String gender; // пол true - men, false - women
    private String father;
    private String mother;
    private List<Human> children;

    public Human(String name, int age, String gender, String father, String mother) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        id = idn++; 
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void getInfo() {
        System.out.println("name: " + name + " age: " + age);
    }

    @Override
    public String toString() {
        return "Human{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", father=" + father +
                ", mother=" + mother +
                ", children=" + children +
                '}';
    }
}
