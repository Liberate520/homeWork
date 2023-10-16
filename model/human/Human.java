package model.human;
import model.family.Subject;

public class Human implements Comparable<Human>, Subject {
    private int id;
    private String name;
    private String gender;
    private String father;
    private String mother;
    private int birthdate;
    private String alive_status;
    private String children;

    public Human(int id, String name, String gender, String father, String mother, int birthdate, String alive_status, String children) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.birthdate = birthdate;
        this.alive_status = alive_status;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", father='" + father +'\'' +
                ", mother='" + mother +'\'' +
                ", birth date=" + birthdate +
                ", alive status='" + alive_status + '\'' +
                ", children='" + children + '\'' +
                '}';
    }
    
    @Override
    public int getId() {
        return id;
    }


    @Override
    public int getAge() {
        return birthdate;
    }

     @Override
    public String getFather() {
        return father;
    }

    @Override
    public String getMother() {
        return mother;
    }

    @Override
    public String getName() {
        return name;
    }

    
    @Override
    public String getAlive_status() {
        return alive_status;
    }

    @Override
    public String getChildren() {
        return children;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
