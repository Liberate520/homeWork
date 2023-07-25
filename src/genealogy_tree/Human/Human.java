package genealogy_tree.Human;

import java.io.Serializable;
import java.util.List;


public abstract class Human implements Serializable{

    private String mother, father;
    private List<String> children;
    private Gender gender;
    private String name;
    private int age;


    public Human(String mother, String father, List<String>children, Gender gender, String name, int age) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.gender = gender;
        this.name = name;
        this.age = age;

    }


    public String getName(){

        return name;
    }
    public  String getFather(){

        return father;
    }
    public  String getMother(){

        return mother;
    }
    public List<String> getChildren(){

        return children;
    }
    public Gender getGender(){

        return gender;
    }
    public int getAge(){
        return age;
    }


    @Override
    public  String toString() {
        return "Human{" +
                "Name and Femali = " + name +
                ", Age = " + age +
                ", Parents = " + mother +" , "+ father +
                ", Children = " + children +
                ", Gender =" + gender +
                '}';
    }

}
