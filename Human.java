package Java_OOP.homeWork;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;

    private Integer yearOfBirth;
    private String gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Integer yearOfBirth, String gender) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    public Human(String name, Integer yearOfBirth, String gender, Human father, Human mother) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.father = father;
        father.addChild(this);
        this.mother = mother;
        mother.addChild(this);
    }


    public String getName() {
        return name;
    }

    public List<Human> getChildren() {
        if (children != null)
            return children;
        else
            return this.children = new ArrayList<>();
    }

    public void addChild(Human child){
        if (this.children == null){
            this.children = new ArrayList<>();
            this.children.add(child);
        }
        else
            this.children.add(child);
    }

    @Override
    public String toString() {
        if ((father == null) || (mother == null))
            return name + " (" + yearOfBirth + ")";
        else 
            return name + " (" + yearOfBirth + ")\n\tОтец: " + father.getName() + "\n\tМать: " + mother.getName();
    }
    
    
}
